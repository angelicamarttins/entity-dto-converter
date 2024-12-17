package com.examples.entity_dto_converter.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTOConstructor {

  private String name;
  private Integer age;

  public UserDTOConstructor(String name, Integer age) {
    this.name = name;
    this.age = age;
  }

}
