package com.examples.entity_dto_converter.repository;

import com.examples.entity_dto_converter.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<UserEntity, UUID> {
}
