package com.ggg.logg.domain.user.exception;

import com.ggg.logg.domain.common.ResourceNotFoundException;
import com.ggg.logg.domain.user.UserEntity;

public class UserNotFoundException extends ResourceNotFoundException {

  public UserNotFoundException(String userId) {
    super("email", UserEntity.class, userId);

  }
}
