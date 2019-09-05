package com.greenfoxacademy.erstecreditcardregistryproject.contactdetails;

import com.greenfoxacademy.erstecreditcardregistryproject.creditcard.CreditCard;
import com.greenfoxacademy.erstecreditcardregistryproject.utility.ContactDetailsUtil;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
@NoArgsConstructor
public class ContactDetailsServiceImpl implements ContactDetailsService {
  @Autowired
  private ContactDetailsRepository contactDetailsRepository;

  public ContactDetailsServiceImpl(ContactDetailsRepository contactDetailsRepository) {
    this.contactDetailsRepository = contactDetailsRepository;
  }

  @Override
  public List<ContactDetails> findAllContact() {
    List<ContactDetails> contactDetailsList = new ArrayList<>();
    contactDetailsRepository.findAll().forEach(contactDetails -> contactDetailsList.add(contactDetails));
    return contactDetailsList;
  }

  @Override
  public ContactDetails findContactById(Long id) {
    return contactDetailsRepository.findById(id).orElse(null);
  }

  @Override
  public void saveContact(ContactDetails contactDetails) {
    contactDetailsRepository.save(contactDetails);
  }

  @Override
  public void deleteContact(ContactDetails contactDetails) {
    contactDetailsRepository.delete(contactDetails);
  }

  public void setCreditCardToContactList(List<ContactDetails> contactDetails, CreditCard creditCard){
    contactDetails.forEach(contact-> contact.setCreditCard(creditCard));
  }
}
