package com.ggg.logg.application;

import static org.junit.jupiter.api.Assertions.*;
import static com.ggg.logg.TestConstant.*;

import com.ggg.logg.application.user.UserService;
import com.ggg.logg.application.user.UserServiceImpl;
import com.ggg.logg.domain.user.User;
import com.ggg.logg.domain.user.exception.IllegalPasswordException;
import com.ggg.logg.domain.common.ResourceNotFoundException;
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

    //when
    User user = userService.loginByUserIdAndPassword(TEST_ID, TEST_PASSWORD);

    //then
    assertNotNull(user);
    assertEquals(user.getUserNickname(), TEST_NICKNAME);
  }

  @Test
  @DisplayName("올바르지 않은 아이디를 입력 시 로그인에 실패한다")
  public void invalidIdLoginTest() {
    //given

    //when
    User idFailureUser = null;
    try {
      idFailureUser = userService.loginByUserIdAndPassword(INVALID_ID, TEST_PASSWORD);
    } catch (ResourceNotFoundException | IllegalPasswordException ignored) {
    }

    //then
    assertNull(idFailureUser);
  }

  @Test
  @DisplayName("올바르지 않은 비밀번호를 입력 시 로그인에 실패한다")
  public void invalidPasswordLoginTest() {
    //given

    //when
    User passwordFailureResultUser = null;
    try {
      passwordFailureResultUser = userService.loginByUserIdAndPassword(TEST_ID,
          INVALID_PASSWORD);
    } catch (ResourceNotFoundException | IllegalPasswordException ignored) {
    }

    //then
    assertNull(passwordFailureResultUser);
  }
}