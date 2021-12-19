package com.kuzi.core.microservice.service;

import com.kuzi.core.microservice.entity.User;
import com.kuzi.core.microservice.kafka.producer.UserEventProducer;
import com.kuzi.core.microservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

  @Autowired private UserRepository userRepository;

  @Autowired private UserEventProducer producer;

  public User saveUser(User user) {

    User promo =
        User.builder().firstName("Hakan").lastName("Kuzi").email("hakankuzi@gmail.com").build();
    userRepository.save(promo);
    return promo;
  }

  public List<User> getUsers() {
    User promo =
        User.builder().firstName("Hakan").lastName("Kuzi").email("hakankuzi@gmail.com").build();
    producer.publish(promo);
    return userRepository.findAll();
  }
}
