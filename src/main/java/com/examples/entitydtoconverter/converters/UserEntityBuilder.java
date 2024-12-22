package com.examples.entitydtoconverter.converters;

import com.examples.entitydtoconverter.dto.UserDtoBuilder;
import com.examples.entitydtoconverter.model.UserEntity;
import java.time.LocalDateTime;
import java.util.UUID;

public class UserEntityBuilder {

  public UserEntity toEntityBuilder(UserDtoBuilder userDtoBuilder) {
    return UserEntity
      .builder()
      .name(userDtoBuilder.getName())
      .age(userDtoBuilder.getAge())
      .userId(UUID.randomUUID())
      .createdAt(LocalDateTime.now())
      .build();
  }

}
