package com.kuzi.core.microservice.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ApiException {
  private String message;
  private HttpStatus httpStatus;
  private ZonedDateTime zonedDateTime;
}
