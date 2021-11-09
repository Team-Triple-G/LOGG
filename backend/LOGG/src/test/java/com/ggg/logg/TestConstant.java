package com.ggg.logg;

import com.ggg.logg.domain.user.User;
import com.ggg.logg.domain.user.UserDetail;

/**
 * 테스트에 사용할 상수 객체 정의
 * <p>
 * invalid user dto 추가
 *
 * @author cherrytomato1
 * @version 1.0.2
 */

public class TestConstant {

  public static final String TEST_EMAIL = "ggg@ggg.com";
  public static final String TEST_PASSWORD = "gurogarbageguys";
  public static final String TEST_NICKNAME = "쓰레기맨";
  public static final User TEST_USER_DTO =
      User.builder().email(TEST_EMAIL)
          .userDetail(UserDetail.builder().nickname(TEST_NICKNAME).build()).password(TEST_PASSWORD)
          .build();

  public static final String INVALID_EMAIL = "Ggg";
  public static final String INVALID_NICKNAME = "휴흉";
  public static final String INVALID_PASSWORD = "gugugur";
  public static final User INVALID_USER_DTO = User.builder().email(INVALID_EMAIL).userDetail(
      UserDetail.builder().nickname(INVALID_NICKNAME).build()).password(INVALID_PASSWORD).build();

}
