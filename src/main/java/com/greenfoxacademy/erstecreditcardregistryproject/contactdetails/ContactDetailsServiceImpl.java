package com.greenfoxacademy.erstecreditcardregistryproject.contactdetails;

import java.util.List;

public class ContactDetailsServiceImpl implements ContactDetailsService{

  private ContactDetailsRepository contactDetailsRepository;

  public ContactDetailsServiceImpl(ContactDetailsRepository contactDetailsRepository){
    this.contactDetailsRepository = contactDetailsRepository;
  }

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
