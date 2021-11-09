package com.ggg.logg.application.user;


import com.ggg.logg.application.ApplicationService;
import com.ggg.logg.domain.user.User;

/**
 * user application service의 서비스 추상클래스
 * <p>
 * 중복체크 메서드 추가
 *
 * @author cherrytomato1
 * @version 1.0.2
 */

public interface UserService extends ApplicationService {

  User loginByEmailAndPassword(String email, String password);

  User registerUser(User user);

  boolean isDuplicateEmail(String email);

  boolean isDuplicateNickname(String nickname);
}
