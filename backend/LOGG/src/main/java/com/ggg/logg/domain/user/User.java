package com.ggg.logg.domain.user;

import com.ggg.logg.domain.common.DomainModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@DomainModel
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {
  String email;
  UserDetail userDetail;
}
