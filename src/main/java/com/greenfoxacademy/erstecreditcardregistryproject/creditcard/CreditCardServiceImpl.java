package com.greenfoxacademy.erstecreditcardregistryproject.creditcard;

import com.greenfoxacademy.erstecreditcardregistryproject.utility.CreditCardUtil;
import lombok.NoArgsConstructor;
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

  @Override
  public List<CreditCard> findAll() {
    return null;
  }

  @Override
  public ResponseEntity<String> findByCardNumber(String cardNumber) {
    if (creditCardRepository.findCreditCardByCardNumber(cardNumber) == null) {
      return new ResponseEntity<>("No credit card with this number",
          HttpStatus.INTERNAL_SERVER_ERROR);
    }
    CreditCardDTO creditCardDto = CreditCardUtil
        .copyObjectoToDTO(creditCardRepository.findCreditCardByCardNumber(cardNumber));
    return new ResponseEntity<>(CreditCardUtil.convertCreditCardDTOToJson(creditCardDto),
        HttpStatus.OK);
  }

  @Override
  public void saveCard(CreditCard creditCard) {
  }

  @Override
  public void deleteCard(CreditCard creditCard) {
  }
}
