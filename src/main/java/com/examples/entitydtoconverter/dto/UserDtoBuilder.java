package com.examples.entitydtoconverter.dto;

import com.examples.entitydtoconverter.model.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDtoBuilder {

  private String name;
  private Integer age;

  public UserDtoBuilder toDto(UserEntity userEntity) {
    return UserDtoBuilder
      .builder()
      .name(userEntity.getName())
      .age(userEntity.getAge())
      .build();
  }

}
