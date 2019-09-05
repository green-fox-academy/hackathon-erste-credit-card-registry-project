package com.greenfoxacademy.erstecreditcardregistryproject.contactdetails;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ContactDetailsDTO {
  private String contactType;
  private String contactInfo;

  public ContactDetailsDTO(ContactDetails contactDetails){
    this.contactType = contactDetails.getContactType().name();
    this.contactInfo = contactDetails.getContactInfo();
  }
}
