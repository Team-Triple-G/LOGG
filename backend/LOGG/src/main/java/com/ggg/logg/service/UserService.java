package com.ggg.logg.service;


import com.ggg.logg.model.dto.UserDto;

public interface UserService {

  UserDto loginByUserIdAndPassword(String userId, String userPassword);
}
