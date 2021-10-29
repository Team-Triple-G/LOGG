package com.ggg.logg.model.exception;

import org.springframework.http.HttpStatus;

public class NotFoundException extends RuntimeException {

  final HttpStatus responseStatus = HttpStatus.NOT_FOUND;
  String resourceName;
  String key;
  Object value;

  public NotFoundException(String resourceName, String key, Object value) {
    super(String.format("%s not found with %s : %s", resourceName, key, value));
    this.key = key;
    this.resourceName = resourceName;
    this.value = value;
  }
}
