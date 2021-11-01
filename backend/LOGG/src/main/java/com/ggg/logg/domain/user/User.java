package com.ggg.logg.domain.user;

import com.ggg.logg.domain.common.DomainEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@DomainEntity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {
  String userId;
  String userNickname;
}
