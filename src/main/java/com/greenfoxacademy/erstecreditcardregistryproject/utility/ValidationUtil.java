package com.greenfoxacademy.erstecreditcardregistryproject.utility;

import com.greenfoxacademy.erstecreditcardregistryproject.contactdetails.ContactDetailsDTO;
import com.greenfoxacademy.erstecreditcardregistryproject.creditcard.carddtos.CreditCardInputDTO;
import com.greenfoxacademy.erstecreditcardregistryproject.globalexceptionhandling.exceptiontypes.FiveHundredException;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class ValidationUtil {

  public static boolean isCardNumberValid(String cardNumber) {
    if (cardNumber.equals(null)) {
      throw new FiveHundredException("Missing card number format");
    } else if (!cardNumber.matches("^[1-9]\\d{3}([\\ \\-]?)\\d{4}\\1\\d{4}\\1\\d{4}$")) {
      throw new FiveHundredException("Invalid card format");
    } else {
      return true;
    }
  }

  public static boolean isCvvValid(Integer cvv) {
    if (cvv == null) {
      throw new FiveHundredException("Missing cvv");
    } else if (cvv < 100 || cvv > 999) {
      throw new FiveHundredException("Invalid cvv format");
    } else {
      return true;
    }
  }

  public static boolean isValidExpiry(String expiry) {
    if (expiry.equals(null)) {
      throw new FiveHundredException("Missing expiry format");
    }
    if (!expiry.matches("^(0[1-9]{1}|1[0-2]{1})/\\d{2}$")) {
      throw new FiveHundredException("Invalid expiry format");
    } else {
      return true;
    }
  }

  public static boolean isValidType(String cardType) {
    if (cardType.equals(null)) {
      throw new FiveHundredException("Missing cardType");
    } else {
      List<String> types = Arrays.asList("MASTERCARD_STANDARD", "MASTERCARD_GOLD", "MASTERCARD_WORLD_GOLD",
              "MASTERCARD_STANDARD_DEVIZA",
              "MAESTRO", "MAESTRO_STUDENT",
              "VISA_CLASSIC", "VISA_VIRTUAL", "VISA_ELECTRON");
      if (types.stream().anyMatch(type -> type.equals(cardType.toUpperCase()))) {
        return true;
      } else {
        throw new FiveHundredException("Invalid cardType");
      }
    }
  }

  public static boolean isValidContactDetail(ContactDetailsDTO contactDetailsDTO) {
    boolean boo = contactDetailsDTO.getContactInfo().matches("^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*$");
    boolean boo2 = contactDetailsDTO.getContactType().toUpperCase().equals("EMAIL");
    if (contactDetailsDTO.getContactType().toUpperCase().equals("PHONE")
            && !contactDetailsDTO.getContactInfo()
            .matches("^[0-9]{11}$")) {
      throw new FiveHundredException("Some phone contact is in wrong format");
    } else if (contactDetailsDTO.getContactType().toUpperCase().equals("EMAIL")
            && (!contactDetailsDTO.getContactInfo()
            .matches("^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*$"))) {
      throw new FiveHundredException("Some email contact is in wrong format");
    } else {
      return true;
    }
  }

  public static boolean checkAllContactDetailVailidty(List<ContactDetailsDTO> contactDetailsDTOS) {
    if (!contactDetailsDTOS.isEmpty()) {
      for (ContactDetailsDTO contact : contactDetailsDTOS) {
        if (!isValidContactDetail(contact)) {
          throw new FiveHundredException("Some contact info is in wrong format");
        }
      }
    }
    return true;
  }

  public static boolean checkInputConsistency(CreditCardInputDTO inputDTO) {
    boolean flag;
    if (inputDTO.getType().toUpperCase().startsWith("V")) {
      flag = inputDTO.getCardNumber().startsWith("4");
    } else if (inputDTO.getType().toUpperCase().startsWith("MAS")) {
      flag = inputDTO.getCardNumber().startsWith("5");
    } else if (inputDTO.getType().toUpperCase().startsWith("MAE")) {
      flag = inputDTO.getCardNumber().startsWith("6");
    } else {
      flag = false;
    }
    if (!flag) {
      throw new FiveHundredException("There is an incoherence between cardtype and number");
    } else {
      return flag;
    }
  }

  public static boolean checkIfExpiryIsEarlier(CreditCardInputDTO inputDTO) {
    Date expiry = null;
    try {
      expiry = new SimpleDateFormat("MM/YY").parse(inputDTO.getValidThru());
    } catch (ParseException e) {
      e.printStackTrace();
    }
    if(expiry.after(Timestamp.valueOf(LocalDateTime.now()))){
      return true;
    }else{
      throw new FiveHundredException("Expired!");
    }
  }
}
