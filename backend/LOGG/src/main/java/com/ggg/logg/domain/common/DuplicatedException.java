package com.ggg.logg.domain.common;

import lombok.Getter;
import org.springframework.http.HttpStatus;

/**
 * 중복된 데이터를 사용했을 때 발생하는 예외
 *
 * @author cherrytomato1
 * @version 1.0.0
 */
@Getter
public class DuplicatedException extends RuntimeException {

  public static final HttpStatus responseStatus = HttpStatus.CONFLICT;
  private final String key;
  private final String value;

  public DuplicatedException(String key, String value) {
    super(String.format("%s is already used in %s", value, key));
    this.key = key;
    this.value = value;
  }
}
