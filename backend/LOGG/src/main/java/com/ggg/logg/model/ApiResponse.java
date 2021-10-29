package com.ggg.logg.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

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
