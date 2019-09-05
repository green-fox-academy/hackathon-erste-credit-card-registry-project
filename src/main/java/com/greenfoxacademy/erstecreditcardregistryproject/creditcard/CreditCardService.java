package com.greenfoxacademy.erstecreditcardregistryproject.creditcard;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CreditCardService {

  List<CreditCard> findAll();
  ResponseEntity<String> findByCardNumber(String cardNumber) ;
  void saveCard(CreditCard creditCard);
  void deleteCard(CreditCard creditCard);
  ResponseEntity registerCard(CreditCardInputDTO creditCardInputDTO);
}
