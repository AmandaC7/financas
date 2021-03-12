package gft.financas;

import gft.financas.domain.Lancamento;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class TopicProducer {

    @Value("${topic.name.producer}")
    private String topicName;

//    private final KafkaTemplate<String, String> kafkaTemplate;
      private final KafkaTemplate<String, Lancamento> kafkaTemplate;

    public void send(Lancamento lancamento){
        log.info("Payload enviado: {}", lancamento);
        final String key = UUID.randomUUID().toString();
        kafkaTemplate.send(topicName, key, lancamento);
    }
}
