package com.ggg.logg.application.user;

import com.ggg.logg.domain.common.DuplicatedException;
import com.ggg.logg.domain.user.User;
import com.ggg.logg.infrastructure.domain.jpa.user.UserEntity;
import com.ggg.logg.domain.user.repository.UserRepository;
import com.ggg.logg.domain.user.exception.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * user 도메인의 서비스
 */

@Slf4j
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

  @Override
  public User registerUser(User user) {
    if (isDuplicateEmail(user.getEmail())) {
      throw new DuplicatedException("email", user.getEmail());
    }
    if (isDuplicateNickname(user.getUserDetail().getNickname())) {
      throw new DuplicatedException("nickname", user.getUserDetail().getNickname());
    }
    return userRepository.save(UserEntity.ofUser(user)).toUser();
  }

  @Override
  public boolean isDuplicateEmail(String email) {
    return userRepository.findByEmail(email).isPresent();
  }

  @Override
  public boolean isDuplicateNickname(String nickname) {
    return userRepository.findByNickname(nickname).isPresent();
  }
}
