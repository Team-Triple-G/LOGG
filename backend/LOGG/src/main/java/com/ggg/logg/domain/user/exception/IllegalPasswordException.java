package com.ggg.logg.domain.user.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

/**
 * 비밀번호 입력 오류시 발생하는 예외
 *
 * private 설정 및 getter 추가
 * author: cherrytomato1
 * version: 1.0.2
 */

@Getter
public class IllegalPasswordException extends RuntimeException {

  public static final HttpStatus responseStatus = HttpStatus.UNAUTHORIZED;
  private final String email;
  private final String password;

  public IllegalPasswordException(String email, String password) {
    super(String.format("%s password not equals %s", email, password));
    this.email = email;
    this.password = password;
  }
}
