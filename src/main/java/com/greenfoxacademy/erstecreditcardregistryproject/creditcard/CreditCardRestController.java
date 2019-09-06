package com.greenfoxacademy.erstecreditcardregistryproject.creditcard;

import com.greenfoxacademy.erstecreditcardregistryproject.creditcard.CreditCardDTO;
import com.greenfoxacademy.erstecreditcardregistryproject.creditcard.CreditCardInputDTO;
import com.greenfoxacademy.erstecreditcardregistryproject.creditcard.CreditCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/ecards")
public class CreditCardRestController {

    @Autowired
    CreditCardService creditCardService;


    @PostMapping("")
    public ResponseEntity registerCard(@RequestBody CreditCardInputDTO creditCardInputDTO){
        return creditCardService.registerCard(creditCardInputDTO);
    }

    @GetMapping("/{cardNumber}")
    public ResponseEntity<String> getCreditCardById(@PathVariable(name="cardNumber") String cardNumber) {
        return creditCardService.findByCardNumber(cardNumber);
    }


    @PutMapping("/{cardNumber}")
    public ResponseEntity<String> blockCreditCard(@PathVariable(name = "cardNumber") String cardNumber) {
        return creditCardService.blockCard(cardNumber);
    }
}
