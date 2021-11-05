package com.ggg.logg.application;

import static org.junit.jupiter.api.Assertions.*;
import static com.ggg.logg.TestConstant.*;
import static org.mockito.BDDMockito.given;

import com.ggg.logg.application.user.UserService;
import com.ggg.logg.application.user.UserServiceImpl;
import com.ggg.logg.domain.user.User;
import com.ggg.logg.domain.user.UserDetail;
import com.ggg.logg.domain.user.UserEntity;
import com.ggg.logg.domain.user.repository.UserRepository;
import com.ggg.logg.domain.user.exception.IllegalPasswordException;
import com.ggg.logg.domain.common.ResourceNotFoundException;

import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
class UserServiceTest {

  @MockBean
  UserRepository userRepository;

  private UserService userService;

  @BeforeEach
  public void setUp() {
    this.userService = new UserServiceImpl(userRepository);
  }

  @Test
  @DisplayName("올바른 닉네임과 비밀번호를 입력하면 로그인에 성공한다")
  public void loginSuccessTest() {
    //given
    given(this.userRepository
        .findByEmail(TEST_EMAIL))
        .willReturn(Optional
            .of(UserEntity.builder()
                .email(TEST_EMAIL)
                .nickname(TEST_NICKNAME)
                .password(TEST_PASSWORD)
                .build()));

    //when
    User user = userService.loginByEmailAndPassword(TEST_EMAIL, TEST_PASSWORD);

    //then
    assertNotNull(user);
    assertEquals(user.getUserDetail().getNickname(), TEST_NICKNAME);
  }

  @Test
  @DisplayName("올바르지 않은 아이디를 입력 시 로그인에 실패한다")
  public void invalidIdLoginTest() {
    //given
    given(this.userRepository
        .findByEmail(INVALID_EMAIL))
        .willReturn(Optional.empty());

    //when
    User idFailureUser = null;
    try {
      idFailureUser = userService.loginByEmailAndPassword(INVALID_EMAIL, TEST_PASSWORD);
    } catch (ResourceNotFoundException | IllegalPasswordException ignored) {
    }

    //then
    assertNull(idFailureUser);
  }

  @Test
  @DisplayName("올바르지 않은 비밀번호를 입력 시 로그인에 실패한다")
  public void invalidPasswordLoginTest() {
    //given
    given(this.userRepository
        .findByEmail(TEST_EMAIL))
        .willReturn(Optional
            .of(UserEntity.builder()
                .email(TEST_EMAIL)
                .nickname(TEST_NICKNAME)
                .password(TEST_PASSWORD)
                .build()));

    //when
    User passwordFailureResultUser = null;
    try {
      passwordFailureResultUser = userService.loginByEmailAndPassword(TEST_EMAIL,
          INVALID_PASSWORD);
    } catch (ResourceNotFoundException | IllegalPasswordException ignored) {
    }

    //then
    assertNull(passwordFailureResultUser);
  }


  @Test
  @DisplayName("회원 가입 정보가 입력되면 사용자를 리포지토리에 저장한다.")
  public void testRegisterUser() {
    //given
    UserEntity testUserEntity = new UserEntity(TEST_USER_DTO);
    given(this.userRepository.save(testUserEntity)).willReturn(testUserEntity);

    //when
    User resultUser = userService.registerUser(TEST_USER_DTO);


    //then
    assertNotNull(resultUser);
    assertEquals(TEST_USER_DTO, resultUser);
  }
}