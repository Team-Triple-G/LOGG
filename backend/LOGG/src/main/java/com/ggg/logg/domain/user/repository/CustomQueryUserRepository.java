package com.ggg.logg.domain.user.repository;

public interface CustomQueryUserRepository<T, ID> {
  String findPasswordByEmail(String email);
}
