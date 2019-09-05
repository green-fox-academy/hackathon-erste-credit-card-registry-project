package com.greenfoxacademy.erstecreditcardregistryproject.contactdetails;

import java.util.List;

public interface ContactDetailsService {
  List<ContactDetails> findAllContact();
  ContactDetails findContactById(Long id);
  void saveContact(ContactDetails contactDetails);
  void deleteContact(ContactDetails contactDetails);
}
