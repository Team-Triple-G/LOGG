package com.ggg.logg.domain.user.repository;

/**
 * JpaRepository와 같은 인터페이스가 아닌 직접적인 구현 객체가 필요한 리포지토리 메서드를 작성하는 인터페이스.
 *
 * @author cherrytomato1
 * @version 1.0.0
 */
public interface CustomizedUserRepository {

  String findPasswordByEmail(String email);
}
