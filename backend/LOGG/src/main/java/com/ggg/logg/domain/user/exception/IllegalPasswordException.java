package com.ggg.logg.domain.user.exception;

import org.springframework.http.HttpStatus;

/**
 * 비밀번호 입력 오류시 발생하는 예외
 * author: cherrytomato1
 * version: 1.0
 */

public class IllegalPasswordException extends RuntimeException {

  public static final HttpStatus responseStatus = HttpStatus.UNAUTHORIZED;
  String userId;
  String userPassword;

  public IllegalPasswordException(String userId, String userPassword) {
    super(String.format("%s password not equals %s", userId, userPassword));
    this.userId = userId;
    this.userPassword = userPassword;
  }
}
