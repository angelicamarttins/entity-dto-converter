package com.examples.entitydtoconverter.converters;

import com.examples.entitydtoconverter.dto.UserDtoStaticMethod;
import com.examples.entitydtoconverter.model.UserEntity;

public class UserEntityStaticMethod {

  public static UserEntity toEntityStaticMethod(UserDtoStaticMethod userDtoStaticMethod) {
    UserEntity userEntity = new UserEntity();

    userEntity.setName(userDtoStaticMethod.getName());
    userEntity.setAge(userDtoStaticMethod.getAge());

    return userEntity;
  }

}
