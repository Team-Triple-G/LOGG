package com.ggg.logg.web.request.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


/**
 * 회원가입 요청을 처리하기 위한 DTO
 *
 *
 * author: cherrytomato1
 * version: 1.0.0
 *
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserRegisterRequest {
  String email;
  String password;
  String nickname;
}
