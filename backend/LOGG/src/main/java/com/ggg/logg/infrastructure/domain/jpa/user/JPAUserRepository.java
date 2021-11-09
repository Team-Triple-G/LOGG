package com.ggg.logg.infrastructure.domain.jpa.user;

import com.ggg.logg.domain.user.repository.UserRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * UserRepository를 JPARepository로 구현할 인터페이스
 *
 * author: cherrytomato1
 * version: 1.0.0
 */

@Repository("UserRepository")
public interface JPAUserRepository
    extends JpaRepository<UserEntity, String>, UserRepository {

}
