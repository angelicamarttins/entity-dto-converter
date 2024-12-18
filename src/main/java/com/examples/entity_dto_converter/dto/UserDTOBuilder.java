package com.examples.entity_dto_converter.dto;

import com.examples.entity_dto_converter.model.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTOBuilder {

  private String name;
  private Integer age;

  public UserDTOBuilder toDto(UserEntity userEntity) {
    return UserDTOBuilder
        .builder()
        .name(userEntity.getName())
        .age(userEntity.getAge())
        .build();
  }

}
