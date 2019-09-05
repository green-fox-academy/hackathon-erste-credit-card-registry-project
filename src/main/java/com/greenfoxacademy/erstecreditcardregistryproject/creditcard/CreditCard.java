package com.greenfoxacademy.erstecreditcardregistryproject.creditcard;

import com.greenfoxacademy.erstecreditcardregistryproject.contactdetails.ContactDetails;
import javax.persistence.Column;
import javax.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class CreditCard {

  @Column(name = "card_type", nullable = false)
  private CreditCardType cardType;

  @Column(name = "card_number", nullable = false)
  private String cardNumber;

  @Column(name = "expiration_date", nullable = false) // MM/YY format kéne
  private String validThru;

  @Column(name = "hash_code")
  private String hashCode;

  @Column(name = "disabled")
  private boolean disabled;

  @Column(name = "owner")
  private String owner;

  @Column(name = "contact_info")
  private ContactDetails contact;

  public CreditCard() {
  }

  public CreditCard(CreditCardType cardType, String cardNumber, String validThru, String hashCode,
                    boolean disabled, String owner, ContactDetails contact) {
    this.cardType = cardType;
    this.cardNumber = cardNumber;
    this.validThru = validThru;
    this.hashCode = hashCode;
    this.disabled = disabled;
    this.owner = owner;
    this.contact = contact;
  }
}
