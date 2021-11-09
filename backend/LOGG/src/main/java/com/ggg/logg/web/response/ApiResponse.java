package com.ggg.logg.web.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

/**
 * 모든 response를 담는 클래스
 *
 * @param <T> 데이터 타입
 * @author cherrytomato1
 * @version 1.0.0
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class ApiResponse<T> {

  private HttpStatus httpStatus;
  private int statusCode;
  private String message;
  private T data;

  public static <T> ApiResponse<T> of(HttpStatus httpStatus, String message, T data) {
    return new ApiResponse<>(httpStatus, httpStatus.value(), message, data);
  }
}
