package com.ggg.logg.domain.user.exception;

import com.ggg.logg.domain.common.ResourceNotFoundException;
import com.ggg.logg.infrastructure.domain.jpa.user.UserEntity;

/**
 * User엔티티를 찾지 못할 때 발생하는 예외
 *
 * @author cherrytomato1
 * @version 1.0.0
 */
public class UserNotFoundException extends ResourceNotFoundException {

  public UserNotFoundException(String key, String value) {
    super(key, UserEntity.class, value);

  }
}
