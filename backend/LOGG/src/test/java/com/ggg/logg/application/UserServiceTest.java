package com.ggg.logg.application;

import static org.junit.jupiter.api.Assertions.*;
import static com.ggg.logg.TestConstant.*;
import static org.mockito.BDDMockito.given;

import com.ggg.logg.application.user.UserService;
import com.ggg.logg.application.user.UserServiceImpl;
import com.ggg.logg.domain.user.User;

import com.ggg.logg.domain.user.UserEntity;
import com.ggg.logg.domain.user.repository.UserRepository;
import com.ggg.logg.domain.user.exception.IllegalPasswordException;
import com.ggg.logg.domain.common.ResourceNotFoundException;

import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
class UserServiceTest {

  @MockBean
  UserRepository userRepository;

  private UserService userService;

  private final Logger LOGGER = LoggerFactory.getLogger(UserServiceTest.class);

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
  public void registerUserTest() {
    //given
    UserEntity testUserEntity = UserEntity.ofUser(TEST_USER_DTO);
    given(this.userRepository.save(testUserEntity)).willReturn(testUserEntity);

    LOGGER.info("test user dto - {}", TEST_USER_DTO);
    LOGGER.info("test user entity - {}", testUserEntity);
    //when
    User resultUser = userService.registerUser(TEST_USER_DTO);

    //then
    assertNotNull(resultUser);
    assertEquals(TEST_USER_DTO, resultUser);
  }

  @Test
  @DisplayName("중복 이메일을 검사한다.")
  public void checkDuplicateEmailTest() {
    //given
    UserEntity testUserEntity = UserEntity.ofUser(TEST_USER_DTO);
    given(this.userRepository.findByEmail(TEST_EMAIL)).willReturn(Optional.of(testUserEntity));
    given(this.userRepository.findByEmail(INVALID_EMAIL)).willReturn(Optional.empty());

    //when
    boolean successResult = userService.isDuplicateEmail(TEST_EMAIL);
    boolean failureResult = userService.isDuplicateEmail(INVALID_EMAIL);

    //then
    assertFalse(failureResult);
    assertTrue(successResult);
  }

  @Test
  @DisplayName("중복 닉네임을 검사한다.")
  public void checkDuplicateNicknameTest() {
    //given
    UserEntity testUserEntity = UserEntity.ofUser(TEST_USER_DTO);
    given(this.userRepository.findByNickname(TEST_NICKNAME)).willReturn(Optional.of(testUserEntity));
    given(this.userRepository.findByNickname(INVALID_NICKNAME)).willReturn(Optional.empty());

    //when
    boolean failureResult = userService.isDuplicateNickname(TEST_NICKNAME);
    boolean successResult = userService.isDuplicateNickname(INVALID_NICKNAME);

    //then
    assertFalse(failureResult);
    assertTrue(successResult);
  }
}