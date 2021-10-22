package com.ggg.logg.model.response.user;

import com.ggg.logg.model.dto.UserDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserLoginResponse {
  UserDto userDto;
  boolean isSuccess;
}
