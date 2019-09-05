package com.greenfoxacademy.erstecreditcardregistryproject.contactdetails;

import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@NoArgsConstructor
public class ContactDetailsServiceImpl implements ContactDetailsService{
  @Autowired
  private ContactDetailsRepository contactDetailsRepository;

  @Override
  public List<ContactDetails> findAllContact() {
    return null;
  }

  @Override
  public ContactDetails findContactById() {
    return null;
  }

  @Override
  public void saveContact(ContactDetails contactDetails) {

  }

  @Override
  public void deleteContact(ContactDetails contactDetails) {

  }
}
