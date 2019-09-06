package com.greenfoxacademy.erstecreditcardregistryproject.creditcard.carddtos;

import java.util.List;

import com.greenfoxacademy.erstecreditcardregistryproject.contactdetails.ContactDetailsDTO;
import com.greenfoxacademy.erstecreditcardregistryproject.creditcard.CreditCardType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CreditCardDTO {
  private CreditCardType cardType;
  private String cardNumber;
  private String validThru;
  private boolean disabled;
  private String owner;
  private List<ContactDetailsDTO> contact;
}