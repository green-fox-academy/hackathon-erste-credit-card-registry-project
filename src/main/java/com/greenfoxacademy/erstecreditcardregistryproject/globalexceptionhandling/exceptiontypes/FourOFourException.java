package com.greenfoxacademy.erstecreditcardregistryproject.globalexceptionhandling.exceptiontypes;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class FourOFourException extends RuntimeException {
  public FourOFourException(String message) {
    super(message);
  }
}
