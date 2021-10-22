package com.ggg.logg.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class UserServiceTest {

  UserService userService;

  @BeforeEach
  public void setUp() {
    userService = new UserServiceImpl();
  }

  @Test
  @DisplayName("올바른 닉네임과 비밀번호를 입력하면 로그인에 성공한다")
  public void loginSuccessTest() {
    //given
    final String TEST_ID = "GGG";
    final String TEST_PASSWORD = "gurogarbageguys";

    //when
//    boolean result =

    //then
    assertDoesNotThrow(userService.loginByUserIdAndPassword(TEST_ID, TEST_PASSWORD));
  }

  @Test
  @DisplayName("올바르지 않은 닉네임 혹은 비밀번호를 입력하면 로그인에 실패한다")
  public void loginFailureTest() {
    //given
    final String TEST_ID = "GGG";
    final String TEST_PASSWORD = "gurogarbageguys";

    final String WRONG_ID = "GGg";
    final String WRONG_PASSWORD = "gurogarbageguy";

    //when
    boolean idFailureResult = userService.loginByUserIdAndPassword(WRONG_ID, TEST_PASSWORD);
    boolean passwordFailureResult = userService.loginByUserIdAndPassword(TEST_ID, WRONG_PASSWORD);

    //then
    assertFalse(idFailureResult);
    assertFalse(passwordFailureResult);
  }
}