package com.examples.entitydtoconverter.model;

import com.examples.entitydtoconverter.dto.UserDtoConstructor;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.time.LocalDateTime;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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

  public UserEntity(String name, Integer age) {
    this.name = name;
    this.age = age;
  }

  public UserEntity(UserDtoConstructor userDtoConstructor) {
    this.name = userDtoConstructor.getName();
    this.age = userDtoConstructor.getAge();
  }

}
