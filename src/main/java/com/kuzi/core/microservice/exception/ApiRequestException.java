package com.kuzi.core.microservice.exception;

public class ApiRequestException extends RuntimeException {

  public ApiRequestException(String message) {
    super(message); // passing to RuntimeException Object
  }

  public ApiRequestException(String message, Throwable cause) {
    super(message, cause);
  }
}
