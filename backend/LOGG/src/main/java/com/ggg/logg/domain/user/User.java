package com.ggg.logg.domain.user;

import com.ggg.logg.domain.common.DomainModel;
import com.ggg.logg.domain.user.exception.IllegalPasswordException;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Generated;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * User aggregate 루트 도메인
 * <p>
 *
 * equals override
 *
 * author: cherrytomato1
 * version: 1.0.2
 */

@DomainModel
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User {

  private String id;
  private String email;
  private String password;
  private UserDetail userDetail;

  public User verifyPasswordAndReturnUser(String password) {
    if (this.password.equals(password)) {
      return this;
    }
    throw new IllegalPasswordException(this.email, this.password);
  }

  @Override
  @Generated
  public boolean equals(Object o) {
    if (!(o instanceof User)) {
      return false;
    }

    User user = (User) o;
    if (this.id != null && user.getId() != null && this.id.equals(user.getId())) {
      return true;
    }
    try {
      return this.email.equals(user.getEmail());
    } catch (NullPointerException ne) {
      return false;
    }
  }
}
