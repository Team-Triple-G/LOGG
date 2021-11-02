package com.ggg.logg.domain.user;

import com.ggg.logg.domain.common.BaseEntity;
import javax.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserEntity extends BaseEntity {
  String nickname;
  String email;
  String description;
}
