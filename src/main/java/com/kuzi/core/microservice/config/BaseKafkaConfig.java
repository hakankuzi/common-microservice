package com.kuzi.core.microservice.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

import static org.apache.kafka.clients.CommonClientConfigs.REQUEST_TIMEOUT_MS_CONFIG;
import static org.apache.kafka.clients.consumer.ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG;

@Configuration
public class BaseKafkaConfig {

  private final String bootstrapServers;
  private final String requestTimeout;

  BaseKafkaConfig(
      @Value("${spring.kafka.bootstrap.servers}") String bootstrapServers,
      @Value("${spring.kafka.request.timeout.ms}") String requestTimeout) {

    this.bootstrapServers = bootstrapServers;
    this.requestTimeout = requestTimeout;
  }

  public Map<String, Object> defaultConfig() {

    final Map<String, Object> defaultConfigMap = new HashMap<>();
    defaultConfigMap.put(BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
    defaultConfigMap.put(REQUEST_TIMEOUT_MS_CONFIG, requestTimeout);
    return defaultConfigMap;
  }
}
