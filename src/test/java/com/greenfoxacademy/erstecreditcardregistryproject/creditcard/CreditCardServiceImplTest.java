package com.greenfoxacademy.erstecreditcardregistryproject.creditcard;

import com.google.gson.Gson;
import com.greenfoxacademy.erstecreditcardregistryproject.globalexceptionhandling.exceptiontypes.FiveHundredException;
import com.greenfoxacademy.erstecreditcardregistryproject.utility.CreditCardUtil;
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

public class CreditCardServiceImplTest {
  private CreditCardDTO creditCardDTO;
  private CreditCard creditCard;

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
    creditCardDTO = CreditCardUtil.copyObjectoToDTO(creditCard);
  }

  @Test
  public void testFindCreditCardByCardNumberAndReturnsOk() {

    when(creditCardRepository.findCreditCardByCardNumber(anyString())).thenReturn(creditCard);
    ResponseEntity responseEntity = creditCardService.findByCardNumber("1111-2222-3333-4444");

    Assert.assertEquals(responseEntity.getBody(), new Gson().toJson(creditCardDTO));
    Assert.assertEquals(responseEntity.getStatusCode(), HttpStatus.OK);
  }


  @Test(expected = FiveHundredException.class)
  public void testFindCreditCardByCardNumberAndReturnsError() {
    when(creditCardRepository.findCreditCardByCardNumber(anyString())).thenReturn(null);

    Assert.assertNull(creditCardService.findByCardNumber("1111-2222-3333-5555"));
  }
}
