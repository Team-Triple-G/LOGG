package com.ggg.logg.domain.user;

import com.ggg.logg.domain.common.DomainModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * User aggregate 루트 도메인
 *
 * author: cherrytomato1
 * version: 1.0.0
 */

@DomainModel
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {
  String email;
  UserDetail userDetail;
}
