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
  private String contactInfo;
  @ManyToOne
  private CreditCard creditCard;


  public ContactDetails(ContactDetailsType contactType, String contactInfo) {
    this.contactType = contactType;
    this.contactInfo = contactInfo;
  }
}
