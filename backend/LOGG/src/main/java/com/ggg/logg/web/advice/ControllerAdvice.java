package com.ggg.logg.web.advice;

import com.ggg.logg.domain.common.DuplicatedException;
import com.ggg.logg.web.response.ApiResponse;
import com.ggg.logg.domain.common.ResourceNotFoundException;
import com.ggg.logg.domain.user.exception.IllegalPasswordException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 컨트롤러 단 예외 발생 시 예외처리 어드바이스
 *
 * duplicated exception 핸들링
 *
 * author: cherrytomato1
 * version: 1.0.1
 */

@RestControllerAdvice
public class ControllerAdvice {

  @ExceptionHandler(value = ResourceNotFoundException.class)
  @ResponseStatus(value = HttpStatus.NOT_FOUND)
  public ApiResponse<?> ResourceNotFoundExceptionHandler(ResourceNotFoundException ex) {
    return ApiResponse.of(HttpStatus.NOT_FOUND, ex.getMessage(), null);
  }

  @ExceptionHandler(value = IllegalPasswordException.class)
  @ResponseStatus(value = HttpStatus.UNAUTHORIZED)
  public ApiResponse<?> IllegalPasswordExceptionHandler(IllegalPasswordException ex) {
    return ApiResponse.of(HttpStatus.UNAUTHORIZED, ex.getMessage(), null);
  }

  @ExceptionHandler(value = DuplicatedException.class)
  @ResponseStatus(value = HttpStatus.CONFLICT)
  public ApiResponse<?> DuplicatedExceptionHandler(DuplicatedException ex) {
    return ApiResponse.of(HttpStatus.CONFLICT, ex.getMessage(), ex.getValue());
  }
}
