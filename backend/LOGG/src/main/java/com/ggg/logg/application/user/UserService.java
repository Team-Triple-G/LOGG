package com.ggg.logg.application.user;


import com.ggg.logg.application.ApplicationService;
import com.ggg.logg.domain.user.User;

public interface UserService extends ApplicationService {

  User loginByEmailAndPassword(String email, String password);

  User registerUser(User user);

  boolean isDuplicateEmail(String email);

  boolean isDuplicateNickname(String nickname);
}
