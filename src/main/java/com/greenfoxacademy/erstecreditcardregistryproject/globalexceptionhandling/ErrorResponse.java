package com.greenfoxacademy.erstecreditcardregistryproject.globalexceptionhandling;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.sql.Timestamp;
import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

public class ErrorResponse {

  private HttpStatus httpStatus;
  private String message;
  private String path;
  @JsonFormat
          (shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
  private Timestamp timeStamp;

  public ErrorResponse() {
  }

  public ErrorResponse(HttpStatus httpStatus, String message, String path) {
    this.httpStatus = httpStatus;
    this.message = message;
    this.path = path;
    this.timeStamp = Timestamp.valueOf(LocalDateTime.now());
  }

  public HttpStatus getHttpStatus() {
    return httpStatus;
  }

  public void setHttpStatus(HttpStatus httpStatus) {
    this.httpStatus = httpStatus;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public String getPath() {
    return path;
  }

  public void setPath(String path) {
    this.path = path;
  }

  public Timestamp getTimeStamp() {
    return timeStamp;
  }

  public void setTimeStamp(Timestamp timeStamp) {
    this.timeStamp = timeStamp;
  }
}
