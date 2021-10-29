package com.ggg.logg;

import com.ggg.logg.model.dto.UserDto;

public class TestConstant {

  public static final String TEST_ID = "GGG";
  public static final String TEST_PASSWORD = "gurogarbageguys";
  public static final String TEST_NICKNAME = "쓰레기맨";
  public static final UserDto TEST_USER_DTO =
      UserDto.builder().userId(TEST_ID).userNickname(TEST_NICKNAME).build();

  public static final String INVALID_ID = "Ggg";
  public static final String INVALID_PASSWORD = "gugugur";

}
