package com.examples.entity_dto_converter.model;

import com.examples.entity_dto_converter.dto.UserDTOConstructor;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity(name = "users")
@Data
@NoArgsConstructor
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