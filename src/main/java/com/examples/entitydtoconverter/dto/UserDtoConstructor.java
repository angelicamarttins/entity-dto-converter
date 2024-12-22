package com.examples.entitydtoconverter.dto;

import com.examples.entitydtoconverter.model.UserEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserDtoConstructor {

  private String name;
  private Integer age;

  public UserDtoConstructor(UserEntity userEntity) {
    this.name = userEntity.getName();
    this.age = userEntity.getAge();
  }

}
