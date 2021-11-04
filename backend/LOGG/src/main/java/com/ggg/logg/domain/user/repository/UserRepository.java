package com.ggg.logg.domain.user.repository;

import com.ggg.logg.domain.user.UserEntity;
import java.util.Optional;

/**
 * userEntity를 사용하는 리포지토리
 *
 * author: cherrytomato1
 * version: 1.0.0
 */
public interface UserRepository<T, ID> extends CustomQueryUserRepository<T, ID>{
  Optional<UserEntity> findByEmail(String email);
  <S extends T> S save(S entity);
}
