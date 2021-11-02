package com.ggg.logg.domain.user;

import static org.junit.jupiter.api.Assertions.*;

import com.ggg.logg.domain.user.exception.UserNotFoundException;
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
  UserRepository userRepository;

  @Test
  @DisplayName("유저 아이디와 비밀번호가 입력되면 데이터 베이스에 저장된다.")
  public void createUserByUserEntity(){
    //given
    UserEntity userEntity = UserEntity.builder().nickname(TEST_NICKNAME).build();

    //when
    UserEntity resultUserEntity = userRepository.save(userEntity);

    //then
    assertEquals(resultUserEntity, userEntity);
  }

  @Test
  @DisplayName("유저 이메일로 사용자를 가져온다")
  public void loadUserByUserId() {
    //given

    //when
    UserEntity userEntity =
        userRepository.findById(TEST_EMAIL).orElseThrow(() -> new UserNotFoundException(TEST_EMAIL));

    //then
    assertNotNull(userEntity);
  }

}