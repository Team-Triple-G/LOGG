package com.ggg.logg;

import com.ggg.logg.domain.user.User;
import com.ggg.logg.domain.user.UserDetail;

public class TestConstant {

  public static final String TEST_ID = "GGG";
  public static final String TEST_PASSWORD = "gurogarbageguys";
  public static final String TEST_NICKNAME = "쓰레기맨";
  public static final User TEST_USER_DTO =
      User.builder().userId(TEST_ID).userDetail(UserDetail.builder().userNickname(TEST_NICKNAME).build()).build();

  public static final String INVALID_ID = "Ggg";
  public static final String INVALID_PASSWORD = "gugugur";

}
