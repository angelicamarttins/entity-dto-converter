package com.examples.entitydtoconverter.dto;

import com.examples.entitydtoconverter.model.UserEntity;
import lombok.Data;

@Data
public class UserDtoManualMapper {

  private String name;
  private Integer age;

  public UserDtoManualMapper toDto(UserEntity userEntity) {
    UserDtoManualMapper userDtoManualMapper = new UserDtoManualMapper();

    userDtoManualMapper.setName(userEntity.getName());
    userDtoManualMapper.setAge(userEntity.getAge());

    return userDtoManualMapper;
  }

}
