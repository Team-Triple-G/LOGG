package com.ggg.logg;

import com.ggg.logg.domain.user.User;
import com.ggg.logg.domain.user.UserDetail;

public class TestConstant {

  public static final String TEST_EMAIL = "ggg@ggg.com";
  public static final String TEST_PASSWORD = "gurogarbageguys";
  public static final String TEST_NICKNAME = "쓰레기맨";
  public static final User TEST_USER_DTO =
      User.builder().email(TEST_EMAIL).userDetail(UserDetail.builder().nickname(TEST_NICKNAME).build()).password(TEST_PASSWORD).build();

  public static final String INVALID_EMAIL = "Ggg";
  public static final String INVALID_PASSWORD = "gugugur";

}
