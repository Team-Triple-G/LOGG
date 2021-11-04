package com.ggg.logg.domain.user.exception;

import org.springframework.http.HttpStatus;

/**
 * 비밀번호 입력 오류시 발생하는 예외
 *
 * id -> email
 * author: cherrytomato1
 * version: 1.0.1
 */

public class IllegalPasswordException extends RuntimeException {

  public static final HttpStatus responseStatus = HttpStatus.UNAUTHORIZED;
  String email;
  String password;

  public IllegalPasswordException(String email, String password) {
    super(String.format("%s password not equals %s", email, password));
    this.email = email;
    this.password = password;
  }
}
