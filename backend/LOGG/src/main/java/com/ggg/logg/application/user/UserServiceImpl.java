package com.ggg.logg.application.user;

import com.ggg.logg.domain.user.User;
import com.ggg.logg.domain.user.UserDetail;
import com.ggg.logg.domain.user.UserEntity;
import com.ggg.logg.domain.user.UserRepository;
import com.ggg.logg.domain.user.exception.IllegalPasswordException;
import com.ggg.logg.domain.user.exception.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * user 도메인의 서비스
 */
@Service("UserService")
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

  private final UserRepository userRepository;

  @Override
  public User loginByEmailAndPassword(String email, String password) {
    return
        userRepository.findByEmail(email).orElseThrow(() -> new UserNotFoundException(
            "email", email)).toUser().verifyPasswordAndReturnUser(password);
  }
}
