package com.greenfoxacademy.erstecreditcardregistryproject.creditcard.carddtos;

import com.greenfoxacademy.erstecreditcardregistryproject.contactdetails.ContactDetailsDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class CreditCardInputDTO {
  private String type;
  private String cardNumber;
  private Integer cvv;
  private String validThru;
  private String owner;
  private List<ContactDetailsDTO> contact;
}
