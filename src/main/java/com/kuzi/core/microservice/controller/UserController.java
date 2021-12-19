package com.kuzi.core.microservice.controller;

import com.kuzi.core.microservice.entity.User;
import com.kuzi.core.microservice.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {

  @Autowired private UserService userService;

  @PostMapping("/")
  public User saveUser(@RequestBody User user) {
    log.info("Inside saveUser of userController");
    return userService.saveUser(user);
  }
}
