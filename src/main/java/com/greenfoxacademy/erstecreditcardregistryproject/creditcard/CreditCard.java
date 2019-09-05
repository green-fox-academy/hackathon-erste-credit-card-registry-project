package com.greenfoxacademy.erstecreditcardregistryproject.creditcard;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CreditCard {

  @Id
  String creditCardNumber;

  public CreditCard() {}

  public CreditCard(String creditCardNumber){
    this.creditCardNumber = creditCardNumber;
  }

  public String getCreditCardNumber() {
    return creditCardNumber;
  }

  public void setCreditCardNumber(String creditCardNumber) {
    this.creditCardNumber = creditCardNumber;
  }
}
