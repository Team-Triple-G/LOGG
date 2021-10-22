package com.ggg.logg.service;

import static org.junit.jupiter.api.Assertions.*;

import com.ggg.logg.model.dto.UserDto;
import com.ggg.logg.model.exception.IllegalPasswordException;
import com.ggg.logg.model.exception.NotFoundException;
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
    final String TEST_NICKNAME = "쓰레기맨";

    //when
    UserDto userDto = userService.loginByUserIdAndPassword(TEST_ID, TEST_PASSWORD);

    //then
    assertNotNull(userDto);
    assertEquals(userDto.getUserName(), TEST_NICKNAME);
  }

  @Test
  @DisplayName("올바르지 않은 닉네임 혹은 비밀번호를 입력하면 로그인에 실패한다")
  public void loginFailureTest() {
    //given
    final String TEST_ID = "GGG";
    final String TEST_PASSWORD = "gurogarbageguys";
    final String TEST_NICKNAME = "쓰레기맨";

    final String WRONG_ID = "GGg";
    final String WRONG_PASSWORD = "gurogarbageguy";

    //when
    UserDto idFailureUserDto = null;
    UserDto passwordFailureResultUserDto = null;
    try {
      idFailureUserDto = userService.loginByUserIdAndPassword(WRONG_ID, TEST_PASSWORD);
      passwordFailureResultUserDto = userService.loginByUserIdAndPassword(TEST_ID,
          WRONG_PASSWORD);
    } catch (NotFoundException | IllegalPasswordException ignored) {
    }

    //then
    assertNull(idFailureUserDto);
    assertNull(passwordFailureResultUserDto);
  }
}