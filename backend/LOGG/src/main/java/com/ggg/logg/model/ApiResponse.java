package com.ggg.logg.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class ApiResponse<T> {

  private HttpStatus httpStatus;
  private String message;
  private T data;

  public static <T> ApiResponse<T> of(int statusCode, String message, T data) {
    return new ApiResponse<>(HttpStatus.valueOf(statusCode), message, data);
  }
}
