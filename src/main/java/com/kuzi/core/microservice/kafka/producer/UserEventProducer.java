package com.kuzi.core.microservice.kafka.producer;

import com.kuzi.core.microservice.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserEventProducer {
  private final KafkaTemplate<String, User> kafkaTemplate;
  private final String topic;

  @Autowired
  public UserEventProducer(
      @Value("${spring.kafka.producer.user-producer-event.topic}") String topic,
      KafkaTemplate<String, User> kafkaTemplate) {
    this.topic = topic;
    this.kafkaTemplate = kafkaTemplate;
  }

  public void publish(User user) {
    try {
      log.info("Attempting to publish newly created account: {} to topic: {}", user, topic);
      kafkaTemplate.send(topic, user).get();
      System.out.println("published!");
    } catch (Exception e) {
      log.error("Error while sending newly created account: {} to the topic: {}", user, topic, e);
    }
  }
}
