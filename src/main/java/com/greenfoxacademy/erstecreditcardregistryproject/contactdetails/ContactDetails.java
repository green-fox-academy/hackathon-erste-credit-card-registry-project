package com.greenfoxacademy.erstecreditcardregistryproject.contactdetails;

import com.greenfoxacademy.erstecreditcardregistryproject.creditcard.CreditCard;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

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


  public ContactDetails(ContactDetailsType contactType, String contactInfo){
    this.contactType = contactType;
    this.contactInfo = contactInfo;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public ContactDetailsType getContactType() {
    return contactType;
  }

  public void setContactType(ContactDetailsType contactType) {
    this.contactType = contactType;
  }

  public String getContactInfo() {
    return contactInfo;
  }

  public void setContactInfo(String contactInfo) {
    this.contactInfo = contactInfo;
  }
}
