package com.greenfoxacademy.erstecreditcardregistryproject.app;

import com.greenfoxacademy.erstecreditcardregistryproject.creditcard.CreditCardInputDTO;
import com.greenfoxacademy.erstecreditcardregistryproject.creditcard.CreditCardService;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/ecards")
public class CreditCardRestController {

    @Autowired
    private CreditCardService creditCardService;

    private static final Logger logger =
            LoggerFactory.getLogger(CreditCardRestController.class);


    @PostMapping("")
    public ResponseEntity registerCard(@RequestBody CreditCardInputDTO creditCardInputDTO){
        return creditCardService.registerCard(creditCardInputDTO);
    }

    @GetMapping("/{cardNumber}")
    public ResponseEntity<String> getCreditCardById(@PathVariable(name="cardNumber") String cardNumber) {
        logger.info("Hello na!");
        return creditCardService.findByCardNumber(cardNumber);
    }
}
