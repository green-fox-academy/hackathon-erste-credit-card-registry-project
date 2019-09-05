package com.greenfoxacademy.erstecreditcardregistryproject.contactdetails;

import java.util.List;

public interface ContactDetailsService {
  List<ContactDetails> findAllContact();
  ContactDetails findContactById();
  void saveContact(ContactDetails contactDetails);
  void deleteContact(ContactDetails contactDetails);
}
