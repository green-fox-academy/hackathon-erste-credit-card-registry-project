package com.greenfoxacademy.erstecreditcardregistryproject.creditcard;

import org.springframework.stereotype.Service;

import java.util.List;

public class CreditCardServiceImpl implements CreditCardService{

  private CreditCardRepository creditCardRepository;

  public CreditCardServiceImpl(CreditCardRepository creditCardRepository){
    this.creditCardRepository = creditCardRepository;
  }

  @Override
  public List<CreditCard> findAll() {
    return null;
  }

  @Override
  public CreditCard findById(String cardNumber) {
    return null;
  }

  @Override
  public void saveCard(CreditCard creditCard) {

  }

  @Override
  public void deleteCard(CreditCard creditCard) {
  }
}
