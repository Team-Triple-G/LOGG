package com.ggg.logg.domain.user.repository;

import com.ggg.logg.domain.user.UserEntity;
import java.util.Optional;

/**
 * userEntity를 사용하는 리포지토리
 *
 * author: cherrytomato1
 * version: 1.0.0
 */

public interface UserRepository extends CustomizedUserRepository {
  Optional<UserEntity> findByEmail(String email);
  <S extends UserEntity> S save(S entity);
}
