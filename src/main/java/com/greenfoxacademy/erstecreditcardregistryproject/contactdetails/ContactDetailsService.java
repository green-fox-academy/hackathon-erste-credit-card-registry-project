package com.greenfoxacademy.erstecreditcardregistryproject.contactdetails;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ContactDetailsService {
  List<ContactDetails> findAllContact();
  ContactDetails findContactById();
  void saveContact(ContactDetails contactDetails);
  void deleteContact(ContactDetails contactDetails);
}
