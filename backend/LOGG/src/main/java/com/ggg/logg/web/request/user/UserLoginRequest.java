package com.ggg.logg.web.request.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


/**
 * 로그인 요청을 처리하기 위한 DTO
 *
 * userId -> email, userPassword -> password
 * author: cherrytomato1
 * version: 1.0.1
 *
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserLoginRequest {
  String email;
  String password;
}
