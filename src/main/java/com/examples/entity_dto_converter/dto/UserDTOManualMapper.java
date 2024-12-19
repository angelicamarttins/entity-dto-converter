package com.examples.entity_dto_converter.dto;

import com.examples.entity_dto_converter.model.UserEntity;
import lombok.Data;

@Data
public class UserDTOManualMapper {

  private String name;
  private Integer age;

  public UserDTOManualMapper toDto(UserEntity userEntity) {
    UserDTOManualMapper userDTOManualMapper = new UserDTOManualMapper();

    userDTOManualMapper.setName(userEntity.getName());
    userDTOManualMapper.setAge(userEntity.getAge());

    return userDTOManualMapper;
  }

}
