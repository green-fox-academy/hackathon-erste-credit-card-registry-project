package com.greenfoxacademy.erstecreditcardregistryproject.globalexceptionhandling;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.sql.Timestamp;
import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
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
}
