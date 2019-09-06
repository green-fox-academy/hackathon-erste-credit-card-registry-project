package com.greenfoxacademy.erstecreditcardregistryproject.creditcard;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreditCardRepository extends CrudRepository<CreditCard, String> {

  CreditCard findCreditCardByCardNumber(String cardNumber);
}
