package com.greenfoxacademy.erstecreditcardregistryproject.creditcard.carddtos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ValidationInputDTO {
  private String type;
  private String cardNumber;
  private Integer cvv;
  private String validThru;
  private boolean disabled;
}
