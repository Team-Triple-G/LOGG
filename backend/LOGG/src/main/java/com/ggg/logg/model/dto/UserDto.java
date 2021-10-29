package com.ggg.logg.model.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UserDto {
  String userId;
  String userNickname;
}
