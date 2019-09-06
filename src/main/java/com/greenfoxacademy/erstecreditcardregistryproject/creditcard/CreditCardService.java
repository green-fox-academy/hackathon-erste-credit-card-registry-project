package com.greenfoxacademy.erstecreditcardregistryproject.creditcard;

import com.greenfoxacademy.erstecreditcardregistryproject.creditcard.carddtos.CreditCardInputDTO;
import com.greenfoxacademy.erstecreditcardregistryproject.creditcard.carddtos.ValidationInputDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CreditCardService {
  List<CreditCard> findAllCards();
  ResponseEntity<String> findByCardNumber(String cardNumber) ;
  void saveCard(CreditCard creditCard);
  void deleteCard(CreditCard creditCard);
  ResponseEntity<String> blockCard(String cardNumber);
  ResponseEntity registerCard(CreditCardInputDTO creditCardInputDTO);
  ResponseEntity validateCard(ValidationInputDTO validationInputDTO);
}
