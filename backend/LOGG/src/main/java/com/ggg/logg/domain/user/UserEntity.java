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
 * password 컬럼 추가
 * author: cherrytomato1
 * version: 1.0.1
 */

@Entity(name = "user")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserEntity extends BaseEntity {

  @Column(nullable = false)
  private String email;

  @Column(nullable = false)
  private String nickname;

  @Column(nullable = false)
  private String password;

  private String description;

  public UserEntity(User user) {
    this.email = user.getEmail();
    this.nickname = user.getUserDetail().getNickname();
    this.description = user.getUserDetail().getDescription();
  }

  public User toUser() {
    return User.builder().email(this.email).password(this.password).userDetail(
        UserDetail.builder().nickname(this.nickname).description(this.description).build()).build();
  }
}
