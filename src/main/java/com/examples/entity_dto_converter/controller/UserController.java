package com.examples.entity_dto_converter.controller;

import com.examples.entity_dto_converter.converters.UserEntityBuilder;
import com.examples.entity_dto_converter.converters.UserEntityManualMapper;
import com.examples.entity_dto_converter.converters.UserEntityStaticMethod;
import com.examples.entity_dto_converter.converters.UserMapper;
import com.examples.entity_dto_converter.dto.*;
import com.examples.entity_dto_converter.model.UserEntity;
import com.examples.entity_dto_converter.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/user")
public class UserController {

  private final UserRepository userRepository;
  private final UserMapper userMapper = Mappers.getMapper(UserMapper.class);

  @PostMapping("/dto/constructor")
  public ResponseEntity<UserEntity> saveUserDtoConstructor(@RequestBody UserDTOConstructor requestUser) {
    return ResponseEntity.ok(userRepository.save(new UserEntity(requestUser)));
  }

  @PostMapping("/dto/static-method")
  public ResponseEntity<UserEntity> saveUserDtoStaticMethod(@RequestBody UserDTOStaticMethod requestUser) {
    return ResponseEntity.ok(userRepository.save(UserEntityStaticMethod.toEntityStaticMethod(requestUser)));
  }

  @PostMapping("/dto/builder")
  public ResponseEntity<UserEntity> saveUserDtoBuilder(@RequestBody UserDTOBuilder requestUser) {
    return ResponseEntity.ok(userRepository.save(new UserEntityBuilder().toEntityBuilder(requestUser)));
  }

  @PostMapping("/dto/manual-mapper")
  public ResponseEntity<UserEntity> saveUserDtoManualMapper(@RequestBody UserDTOManualMapper requestUser) {
    return ResponseEntity.ok(new UserEntityManualMapper().toEntityManualMapper(requestUser));
  }

  @PostMapping("/dto/mapstruct")
  public ResponseEntity<UserEntity> saveUserDtoMapStruct(@RequestBody UserDTOMapStruct requestUser) {
    return ResponseEntity.ok(userRepository.save(userMapper.toEntityMapStruct(requestUser)));
  }

  @PostMapping("/entity/constructor")
  public ResponseEntity<UserDTOConstructor> saveUserEntityConstructor(@RequestBody UserEntity userEntity) {
    userRepository.save(userEntity);
    return ResponseEntity.ok(new UserDTOConstructor(userEntity));
  }

  @PostMapping("/entity/static-method")
  public ResponseEntity<UserDTOStaticMethod> saveUserEntityStaticMethod(@RequestBody UserEntity userEntity) {
    userRepository.save(userEntity);
    return ResponseEntity.ok(UserDTOStaticMethod.toDto(userEntity));
  }

  @PostMapping("/entity/builder")
  public ResponseEntity<UserDTOBuilder> saveUserEntityBuilder(@RequestBody UserEntity userEntity) {
    userRepository.save(userEntity);
    return ResponseEntity.ok(new UserDTOBuilder().toDto(userEntity));
  }

  @PostMapping("/entity/manual-mapper")
  public ResponseEntity<UserDTOManualMapper> saveUserEntityManualMapper(@RequestBody UserEntity userEntity) {
    userRepository.save(userEntity);
    return ResponseEntity.ok(new UserDTOManualMapper().toDto(userEntity));
  }

  @PostMapping("/entity/mapstruct")
  public ResponseEntity<UserDTOMapStruct> saveUserEntityMapStruct(@RequestBody UserEntity userEntity) {
    userRepository.save(userEntity);
    return ResponseEntity.ok(userMapper.toDto(userEntity));
  }

//  @PostMapping("/entity/jpa-projection")
//  public ResponseEntity<UserDTOProjection> saveUser(@RequestBody User user) {
//    return ResponseEntity.ok();
//  }

}
