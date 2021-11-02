package com.ggg.logg.domain.user;

import com.ggg.logg.domain.common.BaseEntity;
import javax.persistence.Column;
import javax.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

/**
 * user의 JPA 전용 엔티티
 *
 * author: cherrytomato1
 * version: 1.0.0
 */

@Entity(name = "user")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserEntity extends BaseEntity {

  @Column(nullable = false)
  String email;
  @Column(nullable = false)
  String nickname;
  String description;
}
