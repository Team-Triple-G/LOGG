package com.ggg.logg.domain.user;

import static org.junit.jupiter.api.Assertions.*;

import com.ggg.logg.domain.user.exception.UserNotFoundException;
import com.ggg.logg.domain.user.repository.UserRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
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
  UserRepository<UserEntity, String> userRepository;

  @Test
  @DisplayName("유저 아이디와 비밀번호가 입력되면 데이터 베이스에 저장된다.")
  public void createUserByUserEntity(){
    //given
    UserEntity userEntity =
        UserEntity.builder().nickname(TEST_NICKNAME).password(TEST_PASSWORD).email(TEST_EMAIL).build();

    //when
    UserEntity resultUserEntity = userRepository.save(userEntity);

    //then
    assertEquals(resultUserEntity, userEntity);
  }

  @Test
  @DisplayName("유저 이메일로 사용자를 가져온다")
  public void loadUserByUserEmail() {
    //given

    //when
    UserEntity userEntity =
        userRepository.findByEmail(TEST_EMAIL).orElseThrow(() -> new UserNotFoundException(
            "email", TEST_EMAIL));

    //then
    assertNotNull(userEntity);
  }

  @Test
  @DisplayName("커스텀 쿼리 리포지토리의 의존성을 테스트한다")
  public void testCustomQueryUserRepositoryDependency() {
    //ginen

    //when
    String result = userRepository.findPasswordByEmail(TEST_EMAIL);

    //then
    assertEquals(TEST_PASSWORD, result);
//    assertNull(result);

  }

}