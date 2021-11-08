package com.ggg.logg.domain.user;

import static org.junit.jupiter.api.Assertions.*;

import com.ggg.logg.domain.user.exception.UserNotFoundException;
import com.ggg.logg.domain.user.repository.UserRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static com.ggg.logg.TestConstant.*;

/**
 *
 * UserRepository의 테스트
 *
 * author: cherrytomato1
 * version: 1.0.0
 */
@SpringBootTest
class UserRepositoryTest {

  @Autowired
  UserRepository userRepository;

  private final Logger LOGGER = LoggerFactory.getLogger(UserRepositoryTest.class);

  @Test
  @DisplayName("유저 아이디와 비밀번호가 입력되면 데이터 베이스에 저장된다.")
  public void createUserByUserEntity(){
    //given
    UserEntity userEntity =
        UserEntity.builder().nickname(TEST_NICKNAME).password(TEST_PASSWORD).email(TEST_EMAIL).build();

//    UserEntity userEntity = UserEntity.ofUser(TEST_USER_DTO);

    LOGGER.info("user entity - {}", userEntity);

    //when
    UserEntity resultUserEntity = userRepository.save(userEntity);

    LOGGER.info("result user entity - {}", resultUserEntity);

    //then
    assertEquals(resultUserEntity, userEntity);
  }

  @Test
  @DisplayName("유저 이메일로 사용자를 가져온다")
  public void loadUserByUserEmail() {
    //given

    //when
    User userEntity =
        userRepository.findByEmail(TEST_EMAIL).orElseThrow(() -> new UserNotFoundException(
            "email", TEST_EMAIL)).toUser();

    //then
    assertNotNull(userEntity);
  }

  @Test
  @DisplayName("사용자 이메일로 비밀번호를 받아온다.")
  public void testCustomQueryUserRepositoryDependency() {
    //ginen

    //when
    System.out.println(TEST_EMAIL);
    Object result = userRepository.findPasswordByEmail(TEST_EMAIL);

    //then
    assertEquals(TEST_PASSWORD, result);
  }

}