package com.ggg.logg.domain.user.exception;

import com.ggg.logg.domain.common.ResourceNotFoundException;

public class UserNotFoundException extends ResourceNotFoundException {

  public UserNotFoundException(String resourceName, String key, Object value) {
    super(resourceName, key, value);
  }
}
