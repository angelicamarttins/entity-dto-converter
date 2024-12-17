package com.examples.entity_dto_converter.controller;

import com.examples.entity_dto_converter.dto.UserDTOConstructor;
import com.examples.entity_dto_converter.model.User;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/user")
public class UserController {

  @PostMapping("/dto/constructor")
  public ResponseEntity<User> saveUser(@RequestBody UserDTOConstructor requestUser) {
    return ResponseEntity.ok();
  }

//  @PostMapping("/dto/static-method")
//  public ResponseEntity<User> saveUser(@RequestBody UserDTOStaticMethod requestUser) {
//    return ResponseEntity.ok();
//  }
//
//  @PostMapping("/dto/builder")
//  public ResponseEntity<User> saveUser(@RequestBody UserDTOBuilder requestUser) {
//    return ResponseEntity.ok();
//  }
//
//  @PostMapping("/dto/manual-mapper")
//  public ResponseEntity<User> saveUser(@RequestBody UserDTOManualMapper requestUser) {
//    return ResponseEntity.ok();
//  }
//
//  @PostMapping("/dto/mapstruct")
//  public ResponseEntity<User> saveUser(@RequestBody UserDTOMapStruct requestUser) {
//    return ResponseEntity.ok();
//  }
//
//  @PostMapping("/dto/stream-lambda")
//  public ResponseEntity<User> saveUser(@RequestBody UserDTOStreamLambda requestUser) {
//    return ResponseEntity.ok();
//  }
//
//  @PostMapping("/dto/stream-builder")
//  public ResponseEntity<User> saveUser(@RequestBody UserDTOStreamBuilder requestUser) {
//    return ResponseEntity.ok();
//  }
//
//  @PostMapping("/entity/constructor")
//  public ResponseEntity<UserDTOConstructor> saveUser(@RequestBody User user) {
//    return ResponseEntity.ok();
//  }
//
//  @PostMapping("/entity/static-method")
//  public ResponseEntity<UserDTOStaticMethod> saveUser(@RequestBody User user) {
//    return ResponseEntity.ok();
//  }
//
//  @PostMapping("/entity/builder")
//  public ResponseEntity<UserDTOBuilder> saveUser(@RequestBody User user) {
//    return ResponseEntity.ok();
//  }
//
//  @PostMapping("/entity/manual-mapper")
//  public ResponseEntity<UserDTOManualMapper> saveUser(@RequestBody User user) {
//    return ResponseEntity.ok();
//  }
//
//  @PostMapping("/entity/mapstruct")
//  public ResponseEntity<UserDTOMapStruct> saveUser(@RequestBody User user) {
//    return ResponseEntity.ok();
//  }
//
//  @PostMapping("/entity/stream-lambda")
//  public ResponseEntity<UserDTOStreamLambda> saveUser(@RequestBody User user) {
//    return ResponseEntity.ok();
//  }
//
//  @PostMapping("/entity/stream-builder")
//  public ResponseEntity<UserDTOStreamBuilder> saveUser(@RequestBody User user) {
//    return ResponseEntity.ok();
//  }
//
//  @PostMapping("/entity/jpa-projection")
//  public ResponseEntity<UserDTOProjection> saveUser(@RequestBody User user) {
//    return ResponseEntity.ok();
//  }

}
