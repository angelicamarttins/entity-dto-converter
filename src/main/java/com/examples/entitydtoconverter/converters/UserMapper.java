package com.examples.entitydtoconverter.converters;

import com.examples.entitydtoconverter.dto.UserDtoMapStruct;
import com.examples.entitydtoconverter.model.UserEntity;
import java.time.LocalDateTime;
import java.util.UUID;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper
public abstract class UserMapper {

  @Mapping(source = "name", target = "userName")
  @Mapping(source = "age", target = "userAge")
  public abstract UserDtoMapStruct toDto(UserEntity userEntity);

  @Mapping(source = "userName", target = "name")
  @Mapping(source = "userAge", target = "age")
  @Mapping(target = "userId", ignore = true)
  @Mapping(target = "createdAt", ignore = true)
  public abstract UserEntity toEntityMapStruct(UserDtoMapStruct userDtoMapStruct);

  @AfterMapping
  protected void updateUserEntity(@MappingTarget UserEntity userEntity) {
    if (userEntity.getUserId() == null) {
      userEntity.setUserId(UUID.randomUUID());
    }

    if (userEntity.getCreatedAt() == null) {
      userEntity.setCreatedAt(LocalDateTime.now());
    }
  }

}
