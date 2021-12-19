package com.kuzi.core.microservice.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZoneId;

import static java.time.ZonedDateTime.now;
import static org.springframework.http.HttpStatus.BAD_REQUEST;

@ControllerAdvice
public class ApiExceptionHandler {

  @ExceptionHandler(value = ApiRequestException.class)
  public ResponseEntity<Object> handleApiRequestException(ApiRequestException e) {

    // 1. Create payload containing exception details
    ApiException apiException = new ApiException(e.getMessage(), BAD_REQUEST, now(ZoneId.of("Z")));

    // 2. Return response entity
    return new ResponseEntity<>(apiException, BAD_REQUEST);
  }
}
