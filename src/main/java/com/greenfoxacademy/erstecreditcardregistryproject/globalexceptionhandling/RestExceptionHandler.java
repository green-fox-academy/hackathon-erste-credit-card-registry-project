package com.greenfoxacademy.erstecreditcardregistryproject.globalexceptionhandling;

import com.greenfoxacademy.erstecreditcardregistryproject.globalexceptionhandling.exceptiontypes.FiveHundredException;
import com.greenfoxacademy.erstecreditcardregistryproject.globalexceptionhandling.exceptiontypes.FourOFourException;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import javax.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RestExceptionHandler {

  private ErrorResponse error = new ErrorResponse();

  @ExceptionHandler(FiveHundredException.class)
  public ResponseEntity<?> handleFiveHundredException(FiveHundredException ex,
                                                      HttpServletRequest request) {
    error.setHttpStatus(HttpStatus.INTERNAL_SERVER_ERROR);
    error.setMessage(ex.getMessage());
    error.setPath(request.getRequestURI());
    error.setTimeStamp(Timestamp.valueOf(LocalDateTime.now()));
    return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
  }

  @ExceptionHandler(FourOFourException.class)
  public ResponseEntity<?> handleFourOFourException(FourOFourException ex,
                                                    HttpServletRequest request) {
    error.setHttpStatus(HttpStatus.NOT_FOUND);
    error.setMessage(ex.getMessage());
    error.setPath(request.getRequestURI());
    error.setTimeStamp(Timestamp.valueOf(LocalDateTime.now()));
    return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
  }
}
