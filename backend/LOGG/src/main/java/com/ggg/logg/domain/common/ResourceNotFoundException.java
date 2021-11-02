package com.ggg.logg.domain.common;

import org.springframework.http.HttpStatus;

/**
 * 자원을 조회할 때 오류가 있으면 발생하는 예외
 * 도메인 내에서 공통으로 사용, 각 상세 예외는 상속하여 사용
 * author: cherrytomato1
 * version: 1.0
 */

public class ResourceNotFoundException extends RuntimeException {

  public static final HttpStatus responseStatus = HttpStatus.NOT_FOUND;
  String keyName;
  Object resource;
  String keyValue;

  public ResourceNotFoundException(String keyName, Object resource, String keyValue) {
    super(String.format("%s not found with %s : %s", keyName, resource, keyValue));
    this.resource = resource;
    this.keyName = keyName;
    this.keyValue = keyName;
  }
}
