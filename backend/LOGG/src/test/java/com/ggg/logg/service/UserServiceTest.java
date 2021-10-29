package com.ggg.logg.service;

import static org.junit.jupiter.api.Assertions.*;

import com.ggg.logg.model.dto.UserDto;
import com.ggg.logg.model.exception.user.IllegalPasswordException;
import com.ggg.logg.model.exception.ResourceNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class UserServiceTest {

  UserService userService;

  final String TEST_ID = "GGG";
  final String TEST_PASSWORD = "gurogarbageguys";
  final String TEST_NICKNAME = "쓰레기맨";

  @BeforeEach
  public void setUp() {
    userService = new UserServiceImpl();
  }

  @Test
  @DisplayName("올바른 닉네임과 비밀번호를 입력하면 로그인에 성공한다")
  public void loginSuccessTest() {
    //given

    //when
    UserDto userDto = userService.loginByUserIdAndPassword(TEST_ID, TEST_PASSWORD);

    //then
    assertNotNull(userDto);
    assertEquals(userDto.getUserNickname(), TEST_NICKNAME);
  }

  @Test
  @DisplayName("올바르지 않은 아이디를 입력 시 로그인에 실패한다")
  public void invalidIdLoginTest() {
    //given

    final String WRONG_ID = "GGg";

    //when
    UserDto idFailureUserDto = null;
    try {
      idFailureUserDto = userService.loginByUserIdAndPassword(WRONG_ID, TEST_PASSWORD);
    } catch (ResourceNotFoundException | IllegalPasswordException ignored) {
    }

    //then
    assertNull(idFailureUserDto);
  }

  @Test
  @DisplayName("올바르지 않은 비밀번호를 입력 시 로그인에 실패한다")
  public void invalidPasswordLoginTest() {
    //given

    final String WRONG_PASSWORD = "gurogarbageguy";

    //when
    UserDto passwordFailureResultUserDto = null;
    try {
      passwordFailureResultUserDto = userService.loginByUserIdAndPassword(TEST_ID,
          WRONG_PASSWORD);
    } catch (ResourceNotFoundException | IllegalPasswordException ignored) {
    }

    //then
    assertNull(passwordFailureResultUserDto);
  }
}