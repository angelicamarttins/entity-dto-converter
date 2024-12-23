package com.examples.entitydtoconverter.controller;

import com.examples.entitydtoconverter.converters.UserEntityBuilder;
import com.examples.entitydtoconverter.converters.UserEntityManualMapper;
import com.examples.entitydtoconverter.converters.UserEntityStaticMethod;
import com.examples.entitydtoconverter.converters.UserMapper;
import com.examples.entitydtoconverter.dto.UserDtoBuilder;
import com.examples.entitydtoconverter.dto.UserDtoConstructor;
import com.examples.entitydtoconverter.dto.UserDtoManualMapper;
import com.examples.entitydtoconverter.dto.UserDtoMapStruct;
import com.examples.entitydtoconverter.dto.UserDtoProjection;
import com.examples.entitydtoconverter.dto.UserDtoStaticMethod;
import com.examples.entitydtoconverter.model.UserEntity;
import com.examples.entitydtoconverter.repository.UserRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
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
  public ResponseEntity<UserEntity> saveUserDtoConstructor(
    @io.swagger.v3.oas.annotations.parameters.RequestBody(
      description = "DTO to convert into Entity",
      required = true,
      content = @Content(mediaType = "application/json",
        examples = @ExampleObject(value = "{\"name\": \"JohnDoe\", \"age\": 30}")))
    @RequestBody UserDtoConstructor requestUser
  ) {
    return ResponseEntity.ok(userRepository.save(new UserEntity(requestUser)));
  }

  @PostMapping("/dto/static-method")
  @Operation(summary = "Create UserEntity by DTO static method")
  public ResponseEntity<UserEntity> saveUserDtoStaticMethod(
    @io.swagger.v3.oas.annotations.parameters.RequestBody(
      description = "DTO to convert into Entity",
      required = true,
      content = @Content(mediaType = "application/json",
        examples = @ExampleObject(value = "{\"name\": \"JohnDoe\", \"age\": 30}")))
    @RequestBody UserDtoStaticMethod requestUser
  ) {
    return ResponseEntity.ok(userRepository.save(UserEntityStaticMethod.toEntityStaticMethod(requestUser)));
  }

  @PostMapping("/dto/builder")
  @Operation(summary = "Create UserEntity by DTO builder")
  public ResponseEntity<UserEntity> saveUserDtoBuilder(
    @io.swagger.v3.oas.annotations.parameters.RequestBody(
      description = "DTO to convert into Entity",
      required = true,
      content = @Content(mediaType = "application/json",
        examples = @ExampleObject(value = "{\"name\": \"JohnDoe\", \"age\": 30}")))
    @RequestBody UserDtoBuilder requestUser
  ) {
    return ResponseEntity.ok(userRepository.save(new UserEntityBuilder().toEntityBuilder(requestUser)));
  }

  @PostMapping("/dto/manual-mapper")
  @Operation(summary = "Create UserEntity by DTO manual mapper")
  public ResponseEntity<UserEntity> saveUserDtoManualMapper(
    @io.swagger.v3.oas.annotations.parameters.RequestBody(
      description = "DTO to convert into Entity",
      required = true,
      content = @Content(mediaType = "application/json",
        examples = @ExampleObject(value = "{\"name\": \"JohnDoe\", \"age\": 30}"
        )))
    @RequestBody UserDtoManualMapper requestUser
  ) {
    return ResponseEntity.ok(new UserEntityManualMapper().toEntityManualMapper(requestUser));
  }

  @PostMapping("/dto/mapstruct")
  @Operation(summary = "Create UserEntity by DTO MapStruct")
  public ResponseEntity<UserEntity> saveUserDtoMapStruct(
    @io.swagger.v3.oas.annotations.parameters.RequestBody(
      description = "DTO to convert into Entity",
      required = true,
      content = @Content(mediaType = "application/json",
        examples = @ExampleObject(value = "{"
          + "\"userId\": \"84797a56-84f7-4df0-9805-33206b619065\", "
          + "\"userName\": \"JohnDoe\", "
          + "\"userAge\": 30}, "
          + "\"createdAt\": \"2024-12-17T18:46:40.710937942\""
        )))
    @RequestBody UserDtoMapStruct requestUser
  ) {
    return ResponseEntity.ok(userRepository.save(userMapper.toEntityMapStruct(requestUser)));
  }

  @PostMapping("/entity/constructor")
  @Operation(summary = "Create UserEntity and return DTO by constructor")
  public ResponseEntity<UserDtoConstructor> saveUserEntityConstructor(
    @io.swagger.v3.oas.annotations.parameters.RequestBody(
      description = "Entity to convert into DTO",
      required = true,
      content = @Content(mediaType = "application/json",
        examples = @ExampleObject(value = "{"
          + "\"userId\": \"84797a56-84f7-4df0-9805-33206b619065\", "
          + "\"name\": \"JohnDoe\", "
          + "\"age\": 30}, "
          + "\"createdAt\": \"2024-12-17T18:46:40.710937942\""
        )))
    @RequestBody UserEntity userEntity
  ) {
    userRepository.save(userEntity);
    return ResponseEntity.ok(new UserDtoConstructor(userEntity));
  }

  @PostMapping("/entity/static-method")
  @Operation(summary = "Create UserEntity and return DTO by static method")
  public ResponseEntity<UserDtoStaticMethod> saveUserEntityStaticMethod(
    @io.swagger.v3.oas.annotations.parameters.RequestBody(
      description = "Entity to convert into DTO",
      required = true,
      content = @Content(mediaType = "application/json",
        examples = @ExampleObject(value = "{"
          + "\"userId\": \"84797a56-84f7-4df0-9805-33206b619065\", "
          + "\"name\": \"JohnDoe\", "
          + "\"age\": 30}, "
          + "\"createdAt\": \"2024-12-17T18:46:40.710937942\""
        )))
    @RequestBody UserEntity userEntity
  ) {
    userRepository.save(userEntity);
    return ResponseEntity.ok(UserDtoStaticMethod.toDto(userEntity));
  }

  @PostMapping("/entity/builder")
  @Operation(summary = "Create UserEntity and return DTO by builder")
  public ResponseEntity<UserDtoBuilder> saveUserEntityBuilder(
    @io.swagger.v3.oas.annotations.parameters.RequestBody(
      description = "Entity to convert into DTO",
      required = true,
      content = @Content(mediaType = "application/json",
        examples = @ExampleObject(value = "{"
          + "\"userId\": \"84797a56-84f7-4df0-9805-33206b619065\", "
          + "\"name\": \"JohnDoe\", "
          + "\"age\": 30}, "
          + "\"createdAt\": \"2024-12-17T18:46:40.710937942\""
        )))
    @RequestBody UserEntity userEntity
  ) {
    userRepository.save(userEntity);
    return ResponseEntity.ok(new UserDtoBuilder().toDto(userEntity));
  }

  @PostMapping("/entity/manual-mapper")
  @Operation(summary = "Create UserEntity and return DTO by manual mapper")
  public ResponseEntity<UserDtoManualMapper> saveUserEntityManualMapper(
    @io.swagger.v3.oas.annotations.parameters.RequestBody(
      description = "Entity to convert into DTO",
      required = true,
      content = @Content(mediaType = "application/json",
        examples = @ExampleObject(value = "{"
          + "\"userId\": \"84797a56-84f7-4df0-9805-33206b619065\", "
          + "\"name\": \"JohnDoe\", "
          + "\"age\": 30}, "
          + "\"createdAt\": \"2024-12-17T18:46:40.710937942\""
        )))
    @RequestBody UserEntity userEntity
  ) {
    userRepository.save(userEntity);
    return ResponseEntity.ok(new UserDtoManualMapper().toDto(userEntity));
  }

  @PostMapping("/entity/mapstruct")
  @Operation(summary = "Create UserEntity and return DTO by MapStruct")
  public ResponseEntity<UserDtoMapStruct> saveUserEntityMapStruct(
    @io.swagger.v3.oas.annotations.parameters.RequestBody(
      description = "Entity to convert into DTO",
      required = true,
      content = @Content(mediaType = "application/json",
        examples = @ExampleObject(value = "{"
          + "\"userId\": \"84797a56-84f7-4df0-9805-33206b619065\", "
          + "\"name\": \"JohnDoe\", "
          + "\"age\": 30}, "
          + "\"createdAt\": \"2024-12-17T18:46:40.710937942\""
        )))
    @RequestBody UserEntity userEntity
  ) {
    userRepository.save(userEntity);
    return ResponseEntity.ok(userMapper.toDto(userEntity));
  }

  @PostMapping("/entity/jpa-projection")
  @Operation(summary = "Create UserEntity and return DTO by JPA projection")
  public ResponseEntity<List<UserDtoProjection>> saveUserEntityProjection(
    @io.swagger.v3.oas.annotations.parameters.RequestBody(
      description = "Entity to convert into DTO",
      required = true,
      content = @Content(mediaType = "application/json",
        examples = @ExampleObject(value = "{"
          + "\"userId\": \"84797a56-84f7-4df0-9805-33206b619065\", "
          + "\"name\": \"JohnDoe\", "
          + "\"age\": 30}, "
          + "\"createdAt\": \"2024-12-17T18:46:40.710937942\""
        )))
    @RequestBody UserEntity userEntity
  ) {
    userRepository.save(userEntity);
    System.out.println("AAAAAAAAAAAAAAAAA" + userEntity);
    return ResponseEntity.ok(userRepository.getUserDtoProjection());
  }

}
