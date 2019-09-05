
package com.greenfoxacademy.erstecreditcardregistryproject.creditcard;

import com.greenfoxacademy.erstecreditcardregistryproject.contactdetails.ContactDetails;
import com.greenfoxacademy.erstecreditcardregistryproject.contactdetails.ContactDetailsServiceImpl;
import com.greenfoxacademy.erstecreditcardregistryproject.globalexceptionhandling.exceptiontypes.FiveHundredException;
import com.greenfoxacademy.erstecreditcardregistryproject.utility.ContactDetailsUtil;
import com.greenfoxacademy.erstecreditcardregistryproject.utility.CreditCardUtil;
import lombok.NoArgsConstructor;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@NoArgsConstructor
public class CreditCardServiceImpl implements CreditCardService {

  @Autowired
  private CreditCardRepository creditCardRepository;
  @Autowired
  private ContactDetailsServiceImpl contactDetailsService;


  @Override
  public List<CreditCard> findAll() {
    return null;
  }

  @Override
  public ResponseEntity findByCardNumber(String cardNumber) {
    if (creditCardRepository.findCreditCardByCardNumber(cardNumber) == null) {
      throw new FiveHundredException("No credit card with this number");
    }else{
    CreditCardDTO creditCardDto = CreditCardUtil.copyObjectoToDTO(creditCardRepository.findCreditCardByCardNumber(cardNumber));
    return new ResponseEntity (CreditCardUtil.copyObjectoToDTO(creditCardRepository.findCreditCardByCardNumber(cardNumber)), HttpStatus.OK);
    }
  }

  @Override
  public void saveCard(CreditCard creditCard) {
    creditCardRepository.save(creditCard);
  }

  @Override
  public void deleteCard(CreditCard creditCard) {
    creditCardRepository.delete(creditCard);
  }

  public ResponseEntity registerCard(CreditCardInputDTO creditCardInputDTO) {
    if(isInputCardInvalid(creditCardInputDTO)){
      throw new FiveHundredException("Something missing");
    }else {
      CreditCard creditCard = getCreditCardReady(creditCardInputDTO);
      saveCard(getCreditCardReady(creditCardInputDTO));
      return ResponseEntity.ok().body(HttpStatus.OK);
    }
  }

  public boolean isInputCardInvalid(CreditCardInputDTO creditCardInputDTO) {
    return creditCardInputDTO.getCardNumber().equals(null) || creditCardInputDTO.getType().equals(null)
            || creditCardInputDTO.getCvv()==null || creditCardInputDTO.getOwner().equals(null)
            || creditCardInputDTO.getContact().isEmpty()|| creditCardRepository.findCreditCardByCardNumber(creditCardInputDTO.getCardNumber())!=null;
  }

  public CreditCard getCreditCardReady(CreditCardInputDTO creditCardInputDTO){
    String hash = new BCrypt().hashpw(creditCardInputDTO.getCardNumber() +  creditCardInputDTO.getValidThru()
            + creditCardInputDTO.getCvv(), BCrypt.gensalt(12));
    List<ContactDetails> contactDetails = ContactDetailsUtil.transformDtoToContact(creditCardInputDTO.getContact());
    CreditCardType creditCardType = CreditCardType.valueOf(creditCardInputDTO.getType().toUpperCase());
    CreditCard resultCard =  new CreditCard(creditCardInputDTO.getCardNumber(),creditCardType,
               creditCardInputDTO.getValidThru(),hash, false, creditCardInputDTO.getOwner(), contactDetails);
    contactDetailsService.setCreditCardToContactList(contactDetails, resultCard);
    return resultCard;
  }
}
