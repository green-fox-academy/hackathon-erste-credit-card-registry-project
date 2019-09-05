package com.greenfoxacademy.erstecreditcardregistryproject.contactdetails;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactDetailsRepository extends CrudRepository<ContactDetails, Long> {
}
