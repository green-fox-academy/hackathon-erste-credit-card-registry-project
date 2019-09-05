package com.greenfoxacademy.erstecreditcardregistryproject.creditcard;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class CreditCard {
  @Id
  private String cardNumber;
  private String cardType;
  private String validThru;
  private boolean disabled;
  private String owner;
  private String type;
  private String contact;

  public CreditCard(String cardNumber) {
      this.cardNumber = cardNumber;
  }
}
