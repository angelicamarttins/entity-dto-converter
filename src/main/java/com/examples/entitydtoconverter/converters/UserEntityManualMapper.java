package com.examples.entitydtoconverter.converters;

import com.examples.entitydtoconverter.dto.UserDtoManualMapper;
import com.examples.entitydtoconverter.model.UserEntity;
import java.time.LocalDateTime;
import java.util.UUID;

public class UserEntityManualMapper {

  public UserEntity toEntityManualMapper(UserDtoManualMapper userDtoManualMapper) {
    return new UserEntity(
      UUID.randomUUID(),
      userDtoManualMapper.getName(),
      userDtoManualMapper.getAge(),
      LocalDateTime.now()
    );
  }

}
