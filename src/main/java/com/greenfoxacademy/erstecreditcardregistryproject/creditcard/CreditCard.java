package com.greenfoxacademy.erstecreditcardregistryproject.creditcard;

import com.greenfoxacademy.erstecreditcardregistryproject.contactdetails.ContactDetails;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class CreditCard {

  @Id
  @Column(name = "card_number", nullable = false)
  private String cardNumber;

  @Column(name = "card_type", nullable = false)
  private CreditCardType cardType;

  @Column(name = "expiration_date", nullable = false) // MM/YY format kéne
  private String validThru;

  @Column(name = "hash_code")
  private String hashCode;

  @Column(name = "disabled")
  private boolean disabled;

  @Column(name = "owner")
  private String owner;

  @OneToMany(cascade = CascadeType.ALL, mappedBy = "creditCard", fetch = FetchType.LAZY)
  private List<ContactDetails> contact;

  public CreditCard(String cardNumber) {
    this.cardNumber = cardNumber;
  }

  public CreditCard(String cardNumber, CreditCardType cardType, String validThru, String hashCode,
                    boolean disabled, String owner, List<ContactDetails> contact) {
    this.cardNumber = cardNumber;
    this.cardType = cardType;
    this.validThru = validThru;
    this.hashCode = hashCode;
    this.disabled = disabled;
    this.owner = owner;
    this.contact = contact;
  }
}
