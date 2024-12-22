package com.examples.entitydtoconverter.repository;

import com.examples.entitydtoconverter.dto.UserDtoProjection;
import com.examples.entitydtoconverter.model.UserEntity;
import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<UserEntity, UUID> {

  @Query("SELECT u.name AS name, u.age AS age FROM users u")
  List<UserDtoProjection> getUserDtoProjection();

}
