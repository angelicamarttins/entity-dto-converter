package com.examples.entity_dto_converter.converters;

import com.examples.entity_dto_converter.dto.UserDTOBuilder;
import com.examples.entity_dto_converter.model.UserEntity;

import java.time.LocalDateTime;
import java.util.UUID;

public class UserEntityBuilder {

  public UserEntity toEntityBuilder(UserDTOBuilder userDTOBuilder) {
    return UserEntity
        .builder()
        .name(userDTOBuilder.getName())
        .age(userDTOBuilder.getAge())
        .userId(UUID.randomUUID())
        .createdAt(LocalDateTime.now())
        .build();
  }

}
