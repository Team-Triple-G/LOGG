package com.ggg.logg.web.response.user;

import com.ggg.logg.domain.user.User;
import lombok.Getter;

@Getter
public class UserLoginResponse {
  String userId;
  String userNickname;

  public UserLoginResponse(User user) {
    this.userId = user.getEmail();
    this.userNickname = user.getUserDetail().getNickname();
  }

  public static UserLoginResponse ofUserDto(User user) {
    return new UserLoginResponse(user);
  }
}
