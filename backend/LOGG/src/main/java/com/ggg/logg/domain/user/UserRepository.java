package com.ggg.logg.domain.user;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * userEntity를 사용하는 리포지토리
 *
 * author: cherrytomato1
 * version: 1.0.0
 */
public interface UserRepository extends JpaRepository<UserEntity, String> {
  Optional<UserEntity> findByEmail(String email);
}
