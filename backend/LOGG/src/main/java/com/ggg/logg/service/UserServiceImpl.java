package com.ggg.logg.service;

import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

  private final String TEMP_USER_ID = "GGG";
  private final String TEMP_USER_PASSWORD = "gurogarbageguys";

  @Override
  public boolean loginByUserIdAndPassword(String userId, String userPassword) {
    if(!userId.equals(TEMP_USER_ID) || !userPassword.equals(TEMP_USER_PASSWORD)) {
      return false;
    }
    return true;
  }
}
