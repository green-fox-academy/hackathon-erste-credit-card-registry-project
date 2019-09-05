package com.greenfoxacademy.erstecreditcardregistryproject.creditcard;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CreditCardService {

  List<CreditCard> findAll();
  CreditCard findById(String cardNumber);
  void saveCard(CreditCard creditCard);
  void deleteCard(CreditCard creditCard);
}
