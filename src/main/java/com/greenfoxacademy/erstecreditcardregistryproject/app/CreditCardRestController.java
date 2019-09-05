package com.greenfoxacademy.erstecreditcardregistryproject.app;

import com.greenfoxacademy.erstecreditcardregistryproject.creditcard.CreditCardDTO;
import com.greenfoxacademy.erstecreditcardregistryproject.creditcard.CreditCardService;
import com.greenfoxacademy.erstecreditcardregistryproject.utility.CreditCardUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/ecards")
public class CreditCardRestController {

    @Autowired
    CreditCardService creditCardService;

    @GetMapping("/{cardNumber}")
    public ResponseEntity<String> getCreditCardById(@PathVariable(name="cardNumber") String cardNumber) {
        return creditCardService.findByCardNumber(cardNumber);
    }

}
