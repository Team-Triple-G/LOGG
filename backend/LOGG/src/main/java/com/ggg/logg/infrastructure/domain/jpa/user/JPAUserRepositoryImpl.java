package com.ggg.logg.infrastructure.domain.jpa.user;

import com.ggg.logg.domain.user.repository.CustomizedUserRepository;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

/**
 * CustomizeUserRepository 를 구현하는 직접 구현 레포지토리 클래스.
 * 명명 규칙은 최종적으로 @Repository어노테이션으로 구현체가 생성되는 인터페이스의 impl 로 작성
 *
 * author: cherrytomato1
 * version: 1.0.0
 */

@Repository
@RequiredArgsConstructor
public class JPAUserRepositoryImpl implements CustomizedUserRepository {

  private final JPAQueryFactory jpaQueryFactory;

  private final QUserEntity qUserEntity = QUserEntity.userEntity;

  @Override
  public String findPasswordByEmail(String email) {
    return jpaQueryFactory.select(qUserEntity.password).from(qUserEntity)
        .where(qUserEntity.email.eq(email)).fetchOne();
  }
}
