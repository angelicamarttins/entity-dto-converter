package com.examples.entity_dto_converter.dto;

import com.examples.entity_dto_converter.model.UserEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserDTOConstructor {

  private String name;
  private Integer age;

  public UserDTOConstructor(UserEntity userEntity) {
    this.name = userEntity.getName();
    this.age = userEntity.getAge();
  }

}
