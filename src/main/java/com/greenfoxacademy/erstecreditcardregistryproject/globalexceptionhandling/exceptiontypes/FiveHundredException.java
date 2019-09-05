package com.greenfoxacademy.erstecreditcardregistryproject.globalexceptionhandling.exceptiontypes;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
public class FiveHundredException extends RuntimeException {
  public FiveHundredException(String message) {
    super(message);
  }
}
