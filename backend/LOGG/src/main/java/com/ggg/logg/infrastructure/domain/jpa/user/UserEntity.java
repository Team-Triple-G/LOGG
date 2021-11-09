package com.ggg.logg.infrastructure.domain.jpa.user;

import com.ggg.logg.domain.user.User;
import com.ggg.logg.domain.user.UserDetail;
import com.ggg.logg.infrastructure.domain.jpa.BaseEntity;
import javax.persistence.Column;
import javax.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * user의 JPA 전용 엔티티
 * <p>
 * equals override
 * <p>
 * @author: cherrytomato1
 * <p>
 * @version: 1.0.2
 */

@Entity(name = "user")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString(callSuper = true)
@Getter
public class UserEntity extends BaseEntity {

  @Column(nullable = false, unique = true)
  private String email;

  @Column(nullable = false, unique = true)
  private String nickname;

  @Column(nullable = false)
  private String password;

  private String description;

  public static UserEntity ofUser(User user) {
    UserDetail userDetail = user.getUserDetail();
    return UserEntity.builder().email(user.getEmail()).password(user.getPassword())
        .nickname(userDetail.getNickname()).description(userDetail.getDescription()).build();
  }

  public User toUser() {
    return User.builder().id(this.id).email(this.email).password(this.password).userDetail(
        UserDetail.builder().nickname(this.nickname).description(this.description).build()).build();
  }

  @Override
  public boolean equals(Object o) {
    if (!(o instanceof UserEntity)) {
      return false;
    }
    UserEntity objectEntity = (UserEntity) o;
    if (this.id != null && objectEntity.getId() != null && this.id.equals(objectEntity.getId())) {
      return true;
    }
    try {
      return this.nickname.equals(objectEntity.getNickname())
          && this.email.equals(objectEntity.getEmail());
    } catch (NullPointerException ne) {
      return false;
    }
  }
}
