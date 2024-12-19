package com.examples.entity_dto_converter.model;

import com.examples.entity_dto_converter.dto.UserDTOBuilder;
import com.examples.entity_dto_converter.dto.UserDTOConstructor;
import com.examples.entity_dto_converter.dto.UserDTOStaticMethod;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "users")
public class UserEntity {

  @Id
  private UUID userId = UUID.randomUUID();
  private String name;
  private Integer age;
  private LocalDateTime createdAt = LocalDateTime.now();

  public UserEntity(UserDTOConstructor userDTOConstructor) {
    this.name = userDTOConstructor.getName();
    this.age = userDTOConstructor.getAge();
  }

}
