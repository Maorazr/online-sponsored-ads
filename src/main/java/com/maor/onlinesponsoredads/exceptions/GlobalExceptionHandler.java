package com.maor.onlinesponsoredads.exceptions;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(CategoryNotFoundException.class)
  public ResponseEntity<Object> handleCategoryNotFound(
    CategoryNotFoundException ex,
    WebRequest request
  ) {
    Map<String, Object> body = createBody(ex.getMessage());

    return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
  }

  public ResponseEntity<Object> handleResourceNotFound(
    ResourceNotFoundException ex,
    WebRequest request
  ) {
    Map<String, Object> body = createBody(ex.getMessage());
    return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
  }

  public ResponseEntity<Object> handleMissingParams(
    MissingServletRequestParameterException ex
  ) {
    Map<String, Object> body = createBody(ex.getMessage());

    return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler(IllegalArgumentException.class)
  public ResponseEntity<Object> handleIllegalArgumentException(
    IllegalArgumentException ex
  ) {
    Map<String, Object> body = createBody(ex.getMessage());

    return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
  }

  private Map<String, Object> createBody(String message) {
    Map<String, Object> body = new LinkedHashMap<>();
    body.put("timestamp", LocalDateTime.now());
    body.put("status", HttpStatus.BAD_REQUEST.value());
    body.put("error", "Bad Request");
    body.put("message", message);

    return body;
  }
}
