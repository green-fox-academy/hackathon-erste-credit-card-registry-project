package com.greenfoxacademy.erstecreditcardregistryproject.creditcard;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CreditCard {
    @Id
    private String cardNubmer;
}
