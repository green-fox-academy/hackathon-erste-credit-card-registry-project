package com.greenfoxacademy.erstecreditcardregistryproject.creditcard;

import com.greenfoxacademy.erstecreditcardregistryproject.creditcard.CreditCard;
import com.greenfoxacademy.erstecreditcardregistryproject.creditcard.CreditCardRepository;
import com.greenfoxacademy.erstecreditcardregistryproject.creditcard.CreditCardServiceImpl;
import com.greenfoxacademy.erstecreditcardregistryproject.creditcard.CreditCardType;
import com.greenfoxacademy.erstecreditcardregistryproject.globalexceptionhandling.exceptiontypes.FourOFourException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

public class CreditCardServiceImpTest {

  private CreditCard creditCard;
  private ResponseEntity responseEntity;

  @InjectMocks
  private CreditCardServiceImpl creditCardService;

  @Mock
  private CreditCardRepository creditCardRepository;

  @Before
  public void setup() {
    MockitoAnnotations.initMocks(this);
    creditCard = new CreditCard();
    creditCard.setDisabled(false);
    creditCard.setValidThru("12/20");
    creditCard.setOwner("John Doe");
    creditCard.setCardNumber("1111-2222-3333-4444");
    creditCard.setCardType(CreditCardType.MAESTRO);
    creditCard.setContact(new ArrayList<>());
  }

  @Test
  public void testBlockCardAndReturnsOk() {
    when(creditCardRepository.findCreditCardByCardNumber(anyString())).thenReturn(creditCard);
    responseEntity = creditCardService.blockCard("1111-2222-3333-4444");

    Assert.assertEquals(responseEntity.getStatusCode(), HttpStatus.OK);
    Assert.assertEquals(responseEntity.getBody(), "This card has been blocked");
    Assert.assertTrue(creditCard.isDisabled());
  }

  @Test(expected = FourOFourException.class)
  public void testBlockCardAndReturnsNotFoundError() {
    when(creditCardRepository.findCreditCardByCardNumber(anyString())).thenReturn(null);

    Assert.assertNull(creditCardService.blockCard("1111-2222-3333-5555"));
  }
}
