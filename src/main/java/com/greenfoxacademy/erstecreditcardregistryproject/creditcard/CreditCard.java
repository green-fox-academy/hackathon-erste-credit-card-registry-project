package com.greenfoxacademy.erstecreditcardregistryproject.creditcard;

import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
public class CreditCard {
    @Id
    private String cardNumber;
}
