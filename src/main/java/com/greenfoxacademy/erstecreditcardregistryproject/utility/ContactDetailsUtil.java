package com.greenfoxacademy.erstecreditcardregistryproject.utility;

import com.greenfoxacademy.erstecreditcardregistryproject.contactdetails.ContactDetails;
import com.greenfoxacademy.erstecreditcardregistryproject.contactdetails.ContactDetailsDTO;

import java.util.ArrayList;
import java.util.List;

public class ContactDetailsUtil {

  public static List<ContactDetailsDTO> transformContactsToDTO(List<ContactDetails> contacts) {
    List<ContactDetailsDTO> result = new ArrayList<>();
    contacts.stream().forEach(contactDetails -> result.add(new ContactDetailsDTO(contactDetails)));
    return result;
  }

  public static List<ContactDetails> transformDtoToContact(List<ContactDetailsDTO> contactDetailsDTOS){
    List<ContactDetails> contactDetailsList = new ArrayList<>();
    contactDetailsDTOS.stream().forEach(contactDetailsDTO-> contactDetailsList.add(new ContactDetails(contactDetailsDTO)));
    return contactDetailsList;
  }
}
