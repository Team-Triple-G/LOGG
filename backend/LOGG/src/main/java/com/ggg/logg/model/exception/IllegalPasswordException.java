package com.ggg.logg.model.exception;

public class IllegalPasswordException extends RuntimeException {

  String userId;
  String userPassword;

  public IllegalPasswordException(String userId, String userPassword) {
    super(String.format("%s password not equals %s", userId, userPassword));
    this.userId = userId;
    this.userPassword = userPassword;
  }
}
