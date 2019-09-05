package com.greenfoxacademy.erstecreditcardregistryproject.creditcard;

import java.util.List;

public interface CreditCardService {

  List<CreditCard> findAll();
  CreditCard findById(String cardNumber);
  void saveCard(CreditCard creditCard);
  void deleteCard(CreditCard creditCard);
}
