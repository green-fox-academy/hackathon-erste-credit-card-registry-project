package com.greenfoxacademy.erstecreditcardregistryproject.creditcard;

import com.google.gson.Gson;
import com.greenfoxacademy.erstecreditcardregistryproject.utility.CreditCardUtil;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

public class CreditCardServiceImplTest {
  private CreditCardDTO creditCardDTO;
  private CreditCard creditCard;
  private ResponseEntity<String> responseEntity;

  @InjectMocks
  private CreditCardServiceImpl creditCardService;

  @Mock
  private CreditCardRepository creditCardRepository;

  @Before
  public void setup() {
    MockitoAnnotations.initMocks(this);
  }

  @Test
  public void testFindCreditCardByCardNumberAndReturnsOk() {
    creditCard = new CreditCard();
    creditCard.setDisabled(false);
    creditCard.setValidThru("12/20");
    creditCard.setOwner("John Doe");
    creditCard.setCardNumber("1111-2222-3333-4444");
    creditCard.setCardType(CreditCardType.MAESTRO);
    creditCardDTO = CreditCardUtil.copyObjectoToDTO(creditCard);

    when(creditCardRepository.findCreditCardByCardNumber(anyString())).thenReturn(creditCard);
    responseEntity = creditCardService.findByCardNumber("1111-2222-3333-4444");

    Assert.assertEquals(responseEntity.getBody(), new Gson().toJson(creditCardDTO));
   // Assert.assertEquals(responseEntity.getStatusCode(), HttpStatus.OK);
  }

  /*@Test
  public void testFindCreditCardByCardNumberAndReturnsError() {
    when(creditCardRepository.findCreditCardByCardNumber(anyString())).thenReturn(null);
    responseEntity = creditCardService.findByCardNumber("1111-2222-3333-5555");

    Assert.assertEquals(responseEntity.getBody(), "No credit card with this number");
    Assert.assertEquals(responseEntity.getStatusCode(), HttpStatus.INTERNAL_SERVER_ERROR);
  }*/
}
