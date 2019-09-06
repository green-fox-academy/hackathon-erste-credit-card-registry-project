package com.greenfoxacademy.erstecreditcardregistryproject.contactdetails;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.greenfoxacademy.erstecreditcardregistryproject.creditcard.CreditCard;

import javax.persistence.*;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class ContactDetails {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column(name = "contact_type", nullable = false)
  private ContactDetailsType contactType;
  @Column
  private String contactInfo;
  @ManyToOne
  @JoinColumn(name = "credit_card", referencedColumnName = "card_number")
  private CreditCard creditCard;

  public ContactDetails(ContactDetailsType contactType, String contactInfo) {
    this.contactType = contactType;
    this.contactInfo = contactInfo;
  }

  public ContactDetails(ContactDetailsDTO contactDetailsDTO) {
    this.contactType = ContactDetailsType.valueOf(contactDetailsDTO.getContactType().toUpperCase());
    this.contactInfo = contactDetailsDTO.getContactInfo();
  }
}
