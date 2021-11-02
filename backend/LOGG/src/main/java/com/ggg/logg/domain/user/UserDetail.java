package com.ggg.logg.domain.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * User aggregate 중 상세 정보
 *
 * author: cherrytomato1
 * version: 1.0.0
 */

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserDetail {
  String nickname;
  String description;
}
