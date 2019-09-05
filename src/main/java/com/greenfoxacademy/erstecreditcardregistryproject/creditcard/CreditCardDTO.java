package com.greenfoxacademy.erstecreditcardregistryproject.creditcard;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CreditCardDTO {
    private String cardType;
    private String cardNumber;
    private String validThru;
    private boolean disabled;
    private String owner;
    private String type;
    private String contact;
}
