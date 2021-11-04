package com.ggg.logg.infrastructure.domain.jpa.user;

import com.ggg.logg.domain.user.UserEntity;
import com.ggg.logg.domain.user.repository.UserRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomUserRepository
    extends UserRepository<UserEntity, String>, JpaRepository<UserEntity, String> {

}
