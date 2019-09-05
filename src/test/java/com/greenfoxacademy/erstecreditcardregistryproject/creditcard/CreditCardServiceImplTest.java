package com.greenfoxacademy.erstecreditcardregistryproject.creditcard;

import org.junit.Before;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class CreditCardServiceImplTest {
  @InjectMocks
  private CreditCardService creditCardService;

  @Mock
  private CreditCardRepository creditCardRepository;

  @Before
  public void setup() throws Exception {
    MockitoAnnotations.initMocks(this);
    CreditCardDTO creditCardDTO = new CreditCardDTO();
    creditCardDTO.setDisabled(false);
    creditCardDTO.setValidThru("12/20");
    creditCardDTO.setOwner("John Doe");
    creditCardDTO.setCardNumber("1111-2222-3333-4444");
    creditCardDTO.setCardType(CreditCardType.MAESTRO);
  }
}
