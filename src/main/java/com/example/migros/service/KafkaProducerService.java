package com.example.migros.service;

import com.example.migros.model.CourierLocationLog;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import static com.example.migros.constants.KafkaConstants.TOPIC_NAME;

@Service
@RequiredArgsConstructor
public class KafkaProducerService {

    private final KafkaTemplate<String, CourierLocationLog> kafkaTemplate;

    public void sendMessage(CourierLocationLog courierLocationLog) {
        kafkaTemplate.send(TOPIC_NAME, courierLocationLog);
    }
}