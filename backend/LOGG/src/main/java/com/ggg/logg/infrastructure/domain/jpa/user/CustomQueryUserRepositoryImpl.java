package com.ggg.logg.infrastructure.domain.jpa.user;

import com.ggg.logg.domain.user.UserEntity;
import com.ggg.logg.domain.user.repository.CustomQueryUserRepository;
import org.springframework.stereotype.Repository;

@Repository
public class CustomQueryUserRepositoryImpl implements CustomQueryUserRepository<UserEntity, String> {

  @Override
  public String findPasswordByEmail(String email) {
    System.out.println("test=================================test"
        + "===============================test \n ===========================test");
    return email;
  }
}
