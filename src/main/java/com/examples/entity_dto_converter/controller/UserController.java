package com.examples.entity_dto_converter.controller;

import com.examples.entity_dto_converter.converters.UserEntityBuilder;
import com.examples.entity_dto_converter.converters.UserEntityManualMapper;
import com.examples.entity_dto_converter.converters.UserEntityStaticMethod;
import com.examples.entity_dto_converter.converters.UserMapper;
import com.examples.entity_dto_converter.dto.*;
import com.examples.entity_dto_converter.model.UserEntity;
import com.examples.entity_dto_converter.repository.UserRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/user")
@Tag(name = "Entity and DTO converter", description = "Entity and DTO converter API")
@ApiResponses({
    @ApiResponse(responseCode = "200", description = "Successfully conversion"),
    @ApiResponse(responseCode = "404", description = "Endpoint not found")
})
public class UserController {

  private final UserRepository userRepository;
  private final UserMapper userMapper = Mappers.getMapper(UserMapper.class);

  @PostMapping("/dto/constructor")
  @Operation(summary = "Create UserEntity by DTO constructor")
  @Parameters({
      @Parameter(name = "requestUser", description = "DTO to convert into Entity", required = true)
  })
  public ResponseEntity<UserEntity> saveUserDtoConstructor(@RequestBody UserDTOConstructor requestUser) {
    return ResponseEntity.ok(userRepository.save(new UserEntity(requestUser)));
  }

  @PostMapping("/dto/static-method")
  @Operation(summary = "Create UserEntity by DTO static method")
  @Parameter(name = "requestUser", description = "DTO to convert into Entity", required = true)
  public ResponseEntity<UserEntity> saveUserDtoStaticMethod(@RequestBody UserDTOStaticMethod requestUser) {
    return ResponseEntity.ok(userRepository.save(UserEntityStaticMethod.toEntityStaticMethod(requestUser)));
  }

  @PostMapping("/dto/builder")
  @Operation(summary = "Create UserEntity by DTO builder")
  @Parameter(name = "requestUser", description = "DTO to convert into Entity", required = true)
  public ResponseEntity<UserEntity> saveUserDtoBuilder(@RequestBody UserDTOBuilder requestUser) {
    return ResponseEntity.ok(userRepository.save(new UserEntityBuilder().toEntityBuilder(requestUser)));
  }

  @PostMapping("/dto/manual-mapper")
  @Operation(summary = "Create UserEntity by DTO manual mapper")
  @Parameter(name = "requestUser", description = "DTO to convert into Entity", required = true)
  public ResponseEntity<UserEntity> saveUserDtoManualMapper(@RequestBody UserDTOManualMapper requestUser) {
    return ResponseEntity.ok(new UserEntityManualMapper().toEntityManualMapper(requestUser));
  }

  @PostMapping("/dto/mapstruct")
  @Operation(summary = "Create UserEntity by DTO MapStruct")
  @Parameter(name = "requestUser", description = "DTO to convert into Entity", required = true)
  public ResponseEntity<UserEntity> saveUserDtoMapStruct(@RequestBody UserDTOMapStruct requestUser) {
    return ResponseEntity.ok(userRepository.save(userMapper.toEntityMapStruct(requestUser)));
  }

  @PostMapping("/entity/constructor")
  @Operation(summary = "Create UserEntity and return DTO by constructor")
  @Parameter(name = "userEntity", description = "Entity to convert into DTO", required = true)
  public ResponseEntity<UserDTOConstructor> saveUserEntityConstructor(@RequestBody UserEntity userEntity) {
    userRepository.save(userEntity);
    return ResponseEntity.ok(new UserDTOConstructor(userEntity));
  }

  @PostMapping("/entity/static-method")
  @Operation(summary = "Create UserEntity and return DTO by static method")
  @Parameter(name = "userEntity", description = "Entity to convert into DTO", required = true)
  public ResponseEntity<UserDTOStaticMethod> saveUserEntityStaticMethod(@RequestBody UserEntity userEntity) {
    userRepository.save(userEntity);
    return ResponseEntity.ok(UserDTOStaticMethod.toDto(userEntity));
  }

  @PostMapping("/entity/builder")
  @Operation(summary = "Create UserEntity and return DTO by builder")
  @Parameter(name = "userEntity", description = "Entity to convert into DTO", required = true)
  public ResponseEntity<UserDTOBuilder> saveUserEntityBuilder(@RequestBody UserEntity userEntity) {
    userRepository.save(userEntity);
    return ResponseEntity.ok(new UserDTOBuilder().toDto(userEntity));
  }

  @PostMapping("/entity/manual-mapper")
  @Operation(summary = "Create UserEntity and return DTO by manual mapper")
  @Parameter(name = "userEntity", description = "Entity to convert into DTO", required = true)
  public ResponseEntity<UserDTOManualMapper> saveUserEntityManualMapper(@RequestBody UserEntity userEntity) {
    userRepository.save(userEntity);
    return ResponseEntity.ok(new UserDTOManualMapper().toDto(userEntity));
  }

  @PostMapping("/entity/mapstruct")
  @Operation(summary = "Create UserEntity and return DTO by MapStruct")
  @Parameter(name = "userEntity", description = "Entity to convert into DTO", required = true)
  public ResponseEntity<UserDTOMapStruct> saveUserEntityMapStruct(@RequestBody UserEntity userEntity) {
    userRepository.save(userEntity);
    return ResponseEntity.ok(userMapper.toDto(userEntity));
  }

  @PostMapping("/entity/jpa-projection")
  @Operation(summary = "Create UserEntity and return DTO by JPA projection")
  @Parameter(name = "userEntity", description = "Entity to convert into DTO", required = true)
  public ResponseEntity<UserDTOProjection> saveUserEntityProjection(@RequestBody UserEntity userEntity) {
    userRepository.save(userEntity);
    return ResponseEntity.ok(userRepository.getUserDTOProjection());
  }

}
