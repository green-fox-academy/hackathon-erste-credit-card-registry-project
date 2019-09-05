package com.greenfoxacademy.erstecreditcardregistryproject.utility;

import com.google.gson.Gson;
import com.greenfoxacademy.erstecreditcardregistryproject.creditcard.CreditCard;
import com.greenfoxacademy.erstecreditcardregistryproject.creditcard.CreditCardDTO;

public class CreditCardUtil {
    public static CreditCardDTO copyObjectoToDTO(CreditCard creditCard) {
        CreditCardDTO creditCardDTO = new CreditCardDTO();
        creditCardDTO.setCardNumber(creditCard.getCardNumber());
        creditCardDTO.setCardType(creditCard.getCardType());
        creditCardDTO.setContact(creditCard.getContact());
        creditCardDTO.setDisabled(creditCard.isDisabled());
        creditCardDTO.setOwner(creditCard.getOwner());
        creditCardDTO.setValidThru(creditCard.getValidThru());
        return creditCardDTO;
    }

    public static String convertCreditCardDTOToJson(CreditCardDTO creditCardDTO) {
        Gson gson = new Gson();
        return gson.toJson(creditCardDTO);
    }
}
