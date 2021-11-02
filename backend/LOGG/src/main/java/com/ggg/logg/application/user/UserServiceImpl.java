package com.ggg.logg.application.user;

import com.ggg.logg.domain.user.User;
import com.ggg.logg.domain.user.UserDetail;
import com.ggg.logg.domain.user.exception.IllegalPasswordException;
import com.ggg.logg.domain.user.exception.UserNotFoundException;
import org.springframework.stereotype.Service;

@Service("UserService")
public class UserServiceImpl implements UserService {

  private final String TEMP_USER_ID = "GGG";
  private final String TEMP_USER_NICKNAME = "쓰레기맨";
  private final String TEMP_USER_PASSWORD = "gurogarbageguys";

  @Override
  public User loginByUserIdAndPassword(String userId, String userPassword) {
    if (!userId.equals(TEMP_USER_ID)) {
      throw new UserNotFoundException(userId);
    }
    if (!userPassword.equals(TEMP_USER_PASSWORD)) {
      throw new IllegalPasswordException(userId, userPassword);
    }
    return User.builder().userId(userId).userDetail(UserDetail.builder()
        .userNickname(TEMP_USER_NICKNAME).build()).build();
  }
}
