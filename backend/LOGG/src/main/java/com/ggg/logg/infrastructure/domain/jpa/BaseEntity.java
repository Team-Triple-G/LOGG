package com.ggg.logg.infrastructure.domain.jpa;

import java.time.LocalDateTime;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

/**
 * JPA Entity 상위 추상 클래스. 공통으로 필요한 colum 작성
 *
 * @author cherrytomato1
 * @version 1.0.0
 */

@ToString
@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseEntity {

  @GenericGenerator(name = "HashIdGenerator", strategy = "com.ggg.logg.infrastructure.domain.jpa"
      + ".HashIdGenerator")
  @GeneratedValue(generator = "HashIdGenerator")
  @Id
  protected String id;

  @CreatedDate
  protected LocalDateTime createdDate;

  @LastModifiedDate
  protected LocalDateTime lastModifiedDate;
}
