package com.greenfoxacademy.erstecreditcardregistryproject.utility;

import com.greenfoxacademy.erstecreditcardregistryproject.creditcard.CreditCard;
import com.greenfoxacademy.erstecreditcardregistryproject.creditcard.CreditCardDTO;

public class CreditCardUtil {

    public static CreditCardDTO copyObjectoToDTO(CreditCard creditCard) {
        CreditCardDTO creditCardDTO = new CreditCardDTO();
        creditCardDTO.setCardNumber(creditCard.getCardNumber());
        creditCardDTO.setCardType(creditCard.getCardType());
        creditCardDTO.setContact(ContactDetailsUtil.transformContactsToDTO(creditCard.getContact()));
        creditCardDTO.setDisabled(creditCard.isDisabled());
        creditCardDTO.setOwner(creditCard.getOwner());
        creditCardDTO.setValidThru(creditCard.getValidThru());
        return creditCardDTO;
    }
}
