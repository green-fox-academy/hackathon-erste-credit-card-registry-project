
package com.greenfoxacademy.erstecreditcardregistryproject.creditcard;

import com.greenfoxacademy.erstecreditcardregistryproject.globalexceptionhandling.exceptiontypes.FourOFourException;
import com.google.gson.Gson;
import com.greenfoxacademy.erstecreditcardregistryproject.contactdetails.ContactDetails;
import com.greenfoxacademy.erstecreditcardregistryproject.contactdetails.ContactDetailsServiceImpl;
import com.greenfoxacademy.erstecreditcardregistryproject.creditcard.carddtos.CreditCardDTO;
import com.greenfoxacademy.erstecreditcardregistryproject.creditcard.carddtos.CreditCardInputDTO;
import com.greenfoxacademy.erstecreditcardregistryproject.creditcard.carddtos.ValidationInputDTO;
import com.greenfoxacademy.erstecreditcardregistryproject.creditcard.carddtos.ValidationResponseDTO;
import com.greenfoxacademy.erstecreditcardregistryproject.globalexceptionhandling.exceptiontypes.FiveHundredException;

import com.greenfoxacademy.erstecreditcardregistryproject.utility.ContactDetailsUtil;
import com.greenfoxacademy.erstecreditcardregistryproject.utility.CreditCardUtil;
import com.greenfoxacademy.erstecreditcardregistryproject.utility.ValidationUtil;
import lombok.NoArgsConstructor;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@NoArgsConstructor
public class CreditCardServiceImpl implements CreditCardService {

  @Autowired
  private CreditCardRepository creditCardRepository;
  @Autowired
  private ContactDetailsServiceImpl contactDetailsService;


  @Override
  public List<CreditCard> findAllCards() {
    List<CreditCard> cards = new ArrayList<>();
    creditCardRepository.findAll().forEach(card -> cards.add(card));
    return cards;
  }

  @Override
  public ResponseEntity<String> findByCardNumber(String cardNumber) {
    if (creditCardRepository.findCreditCardByCardNumber(cardNumber) == null) {
      throw new FiveHundredException("No credit card with this number");
    }else{
    CreditCardDTO creditCardDto = CreditCardUtil.copyObjectoToDTO(creditCardRepository.findCreditCardByCardNumber(cardNumber));
    return new ResponseEntity<> (new Gson().toJson(creditCardDto), HttpStatus.OK);
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

  @Override
  public ResponseEntity registerCard(CreditCardInputDTO creditCardInputDTO) {
    if (isInputCardValid(creditCardInputDTO)) {
      CreditCard creditCard = getCreditCardReady(creditCardInputDTO);
      saveCard(getCreditCardReady(creditCardInputDTO));
      return ResponseEntity.ok().body(HttpStatus.OK);
    } else {
      throw new FiveHundredException("Something wrong with the input");
    }
  }

  public boolean isInputCardValid(CreditCardInputDTO creditCardInputDTO) {
    if (creditCardRepository.findCreditCardByCardNumber(creditCardInputDTO.getCardNumber()) != null) {
      throw new FiveHundredException("This card has been registered already");
    } else {
      return ValidationUtil.isCardNumberValid(creditCardInputDTO.getCardNumber())
              && ValidationUtil.isCvvValid(creditCardInputDTO.getCvv())
              && ValidationUtil.isValidExpiry(creditCardInputDTO.getValidThru())
              && ValidationUtil.isValidType(creditCardInputDTO.getType())
              && ValidationUtil.checkAllContactDetailVailidty(creditCardInputDTO.getContact())
              && ValidationUtil.checkInputConsistency(creditCardInputDTO);
    }
  }

  private CreditCard getCreditCardReady(CreditCardInputDTO creditCardInputDTO) {
    String hash = new BCrypt().hashpw(creditCardInputDTO.getCardNumber() + creditCardInputDTO.getValidThru()
            + creditCardInputDTO.getCvv(), BCrypt.gensalt(12));
    List<ContactDetails> contactDetails = ContactDetailsUtil.transformDtoToContact(creditCardInputDTO.getContact());
    CreditCard resultCard = new CreditCard(creditCardInputDTO.getCardNumber(),
            CreditCardType.valueOf(creditCardInputDTO.getType().toUpperCase()),
            creditCardInputDTO.getValidThru(), hash, false, creditCardInputDTO.getOwner(), contactDetails);
    contactDetailsService.setCreditCardToContactList(contactDetails, resultCard);
    return resultCard;
  }

  @Override
  public ResponseEntity<String> blockCard(String cardNumber) {
    if (creditCardRepository.findCreditCardByCardNumber(cardNumber) != null) {
      creditCardRepository.findCreditCardByCardNumber(cardNumber).setDisabled(true);
      return new ResponseEntity<>("This card has been blocked", HttpStatus.OK);
    } else {
      throw new FourOFourException("Error: There is no card with this number.");
    }
  }

  @Override
  public ResponseEntity validateCard(ValidationInputDTO validationInputDTO) {
    ValidationResponseDTO response = new ValidationResponseDTO();
    if (creditCardRepository.findCreditCardByCardNumber(validationInputDTO.getCardNumber()) == null) {
      response.setResult("Invalid!");
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
    } else {
      CreditCard card = creditCardRepository.findCreditCardByCardNumber(validationInputDTO.getCardNumber());
      if (card.getCardType().name().equals(validationInputDTO.getType().toUpperCase())
              && card.getValidThru().equals(validationInputDTO.getValidThru())
              && BCrypt.checkpw(validationInputDTO.getCardNumber() + validationInputDTO.getValidThru()
              + validationInputDTO.getCvv(), card.getHashCode())
              && !card.isDisabled()) {
        response.setResult("Valid");
        return ResponseEntity.ok().body(response);
      } else {
        response.setResult("Invalid!");
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
      }
    }
  }
}
