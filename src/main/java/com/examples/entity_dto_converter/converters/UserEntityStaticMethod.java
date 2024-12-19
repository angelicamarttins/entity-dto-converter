package com.examples.entity_dto_converter.converters;

import com.examples.entity_dto_converter.dto.UserDTOStaticMethod;
import com.examples.entity_dto_converter.model.UserEntity;

public class UserEntityStaticMethod {

  public static UserEntity toEntityStaticMethod(UserDTOStaticMethod userDTOStaticMethod) {
    UserEntity userEntity = new UserEntity();

    userEntity.setName(userDTOStaticMethod.getName());
    userEntity.setAge(userDTOStaticMethod.getAge());

    return userEntity;
  }

}
