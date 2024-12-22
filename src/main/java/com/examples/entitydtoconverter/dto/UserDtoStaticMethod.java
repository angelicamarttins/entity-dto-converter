package com.examples.entitydtoconverter.dto;

import com.examples.entitydtoconverter.model.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDtoStaticMethod {

  private String name;
  private Integer age;

  public static UserDtoStaticMethod toDto(UserEntity userEntity) {
    return new UserDtoStaticMethod(
      userEntity.getName(),
      userEntity.getAge()
    );
  }

}
