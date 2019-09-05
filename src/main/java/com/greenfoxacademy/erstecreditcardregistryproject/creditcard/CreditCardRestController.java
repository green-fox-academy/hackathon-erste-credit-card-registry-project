package com.greenfoxacademy.erstecreditcardregistryproject.creditcard;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
        logger.info("Card has been added: " + creditCardInputDTO.getCardNumber());
        return creditCardService.registerCard(creditCardInputDTO);
    }

    @GetMapping("/{cardNumber}")
    public ResponseEntity<String> getCreditCardById(@PathVariable(name="cardNumber") String cardNumber) {
        logger.info("Querying card: " + cardNumber);
        return creditCardService.findByCardNumber(cardNumber);
    }

    @PutMapping("/{cardNumber}")
    public ResponseEntity<String> blockCreditCard(@PathVariable(name = "cardNumber") String cardNumber) {
        logger.info("Card has been blocked: " + cardNumber);
        logger.error("");
        return creditCardService.blockCard(cardNumber);
    }
}
