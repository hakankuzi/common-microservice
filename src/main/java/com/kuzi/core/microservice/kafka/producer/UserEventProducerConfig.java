package com.kuzi.core.microservice.kafka.producer;

import com.kuzi.core.microservice.config.BaseKafkaConfig;
import com.kuzi.core.microservice.constants.Common;
import com.kuzi.core.microservice.entity.User;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import java.util.HashMap;
import java.util.Map;

import static com.kuzi.core.microservice.constants.Common.SCHEMA_REGISTRY_URL;
import static java.lang.Integer.MAX_VALUE;
import static org.apache.kafka.clients.producer.ProducerConfig.*;

@EnableKafka
@Configuration
public class UserEventProducerConfig {

  private final String clientId;
  private final String groupId;
  private final String schemaUrl;

  private final BaseKafkaConfig baseKafkaConfig;

  @Autowired
  UserEventProducerConfig(
      @Value("${spring.kafka.producer.user-producer-event.clientId}") final String clientId,
      @Value("${spring.kafka.producer.user-producer-event.groupId}") final String groupId,
      @Value("${spring.kafka.schema.registry.url}") final String schemaUrl,
      final BaseKafkaConfig baseKafkaConfig) {

    this.clientId = clientId;
    this.groupId = groupId;
    this.schemaUrl = schemaUrl;
    this.baseKafkaConfig = baseKafkaConfig;
  }

  @Bean
  public ProducerFactory<String, User> schemaUserProducerFactory() {
    Map<String, Object> props = new HashMap<>(baseKafkaConfig.defaultConfig());
    props.put(KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
    props.put(VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
    props.put(SCHEMA_REGISTRY_URL, schemaUrl);
    props.put(RETRIES_CONFIG, MAX_VALUE);
    return new DefaultKafkaProducerFactory<>(props);
  }

  @Bean
  public KafkaTemplate<String, User> schemaAccountKafkaTemplate() {
    return new KafkaTemplate<>(schemaUserProducerFactory());
  }
}
