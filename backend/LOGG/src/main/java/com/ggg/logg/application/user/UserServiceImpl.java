package com.ggg.logg.application.user;

import com.ggg.logg.domain.user.User;
import com.ggg.logg.domain.user.UserDetail;
import com.ggg.logg.domain.user.exception.IllegalPasswordException;
import com.ggg.logg.domain.user.exception.UserNotFoundException;
import org.springframework.stereotype.Service;

@Service("UserService")
public class UserServiceImpl implements UserService {

  private final String TEMP_USER_EMAIL = "ggg@ggg.com";
  private final String TEMP_USER_NICKNAME = "쓰레기맨";
  private final String TEMP_USER_PASSWORD = "gurogarbageguys";

  @Override
  public User loginByEmailAndPassword(String email, String password) {
    if (!email.equals(TEMP_USER_EMAIL)) {
      throw new UserNotFoundException("email", email);
    }
    if (!password.equals(TEMP_USER_PASSWORD)) {
      throw new IllegalPasswordException(email, password);
    }
    return User.builder().email(email).userDetail(UserDetail.builder()
        .nickname(TEMP_USER_NICKNAME).build()).build();
  }
}
