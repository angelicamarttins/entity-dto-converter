package com.examples.entity_dto_converter.dto;

import com.examples.entity_dto_converter.model.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTOStaticMethod {

  private String name;
  private Integer age;

  public static UserDTOStaticMethod toDto(UserEntity userEntity) {
    return new UserDTOStaticMethod(
        userEntity.getName(),
        userEntity.getAge()
    );
  }

}
