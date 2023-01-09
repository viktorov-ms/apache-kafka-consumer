package localhost.apacheKafkaConsumer.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import localhost.apacheKafkaConsumer.dto.FoodOrderDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@RequiredArgsConstructor
@Component
public class Consumer {

  private final ObjectMapper objectMapper;

  @KafkaListener(topics = "${topic.name}")
  public void consumeMessage(String message) throws JsonProcessingException {
    log.info("message consumed {}", message);

    FoodOrderDto foodOrderDto =
        objectMapper.readValue(message, FoodOrderDto.class);

    System.out.println();
  }
}
