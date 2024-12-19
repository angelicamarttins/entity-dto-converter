package com.examples.entity_dto_converter.converters;

import com.examples.entity_dto_converter.dto.UserDTOManualMapper;
import com.examples.entity_dto_converter.model.UserEntity;

import java.time.LocalDateTime;
import java.util.UUID;

public class UserEntityManualMapper {

  public UserEntity toEntityManualMapper(UserDTOManualMapper userDTOManualMapper) {
    return new UserEntity(
        UUID.randomUUID(),
        userDTOManualMapper.getName(),
        userDTOManualMapper.getAge(),
        LocalDateTime.now()
    );
  }

}
