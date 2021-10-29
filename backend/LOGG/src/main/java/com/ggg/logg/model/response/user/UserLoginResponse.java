package com.ggg.logg.model.response.user;

import com.ggg.logg.model.dto.UserDto;
import lombok.Getter;

@Getter
public class UserLoginResponse {
  String userId;
  String userNickname;

  public UserLoginResponse(UserDto userDto) {
    this.userId = userDto.getUserId();
    this.userNickname = userDto.getUserNickname();
  }

  public static UserLoginResponse ofUserDto(UserDto userDto) {
    return new UserLoginResponse(userDto);
  }
}
