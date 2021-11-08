package com.ggg.logg.web.response.user;

import com.ggg.logg.domain.user.User;
import lombok.Getter;

/**
 * 로그인 요청에 대한 리스폰스.
 *
 * 파라미터값 userId -> email
 * author: cherrytomato1
 * version: 1.0.1
 *
 */
@Getter
public class UserLoginResponse {
  String email;
  String nickname;

  public UserLoginResponse(User user) {
    this.email = user.getEmail();
    this.nickname = user.getUserDetail().getNickname();
  }

  public static UserLoginResponse ofUserDto(User user) {
    return new UserLoginResponse(user);
  }
}
