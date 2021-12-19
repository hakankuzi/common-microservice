package com.kuzi.core.microservice.service;

import com.kuzi.core.microservice.entity.User;
import com.kuzi.core.microservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

  @Autowired private UserRepository userRepository;

  public User saveUser(User user) {
    return userRepository.save(user);
  }
}
