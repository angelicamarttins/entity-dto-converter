package com.examples.entity_dto_converter.converters;

import com.examples.entity_dto_converter.dto.UserDTOMapStruct;
import com.examples.entity_dto_converter.model.UserEntity;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.time.LocalDateTime;
import java.util.UUID;

@Mapper
public abstract class UserMapper {

  @Mapping(source = "name", target = "userName")
  @Mapping(source = "age", target = "userAge")
  public abstract UserDTOMapStruct toDto(UserEntity userEntity);

  @Mapping(source = "userName", target = "name")
  @Mapping(source = "userAge", target = "age")
  @Mapping(target = "userId", ignore = true)
  @Mapping(target = "createdAt", ignore = true)
  public abstract UserEntity toEntityMapStruct(UserDTOMapStruct userDTOMapStruct);

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
