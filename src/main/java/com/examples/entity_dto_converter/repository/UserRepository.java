package com.examples.entity_dto_converter.repository;

import com.examples.entity_dto_converter.dto.UserDTOProjection;
import com.examples.entity_dto_converter.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.UUID;

public interface UserRepository extends JpaRepository<UserEntity, UUID> {

  @Query("SELECT u.name AS name, u.age AS age FROM users u")
  UserDTOProjection getUserDTOProjection();

}
