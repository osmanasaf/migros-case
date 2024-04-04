package com.example.migros.service;

import com.example.migros.model.CourierLocationLog;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.IOException;

import static com.example.migros.constants.KafkaConstants.TOPIC_NAME;

@Service
@RequiredArgsConstructor
public class KafkaConsumerService {

    private final CourierService courierService;

    @KafkaListener(topics = TOPIC_NAME, groupId = "group_id")
    public void kafkaListener(String messagePayload) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            CourierLocationLog courierLocationLog = objectMapper.readValue(messagePayload, CourierLocationLog.class);
            courierService.checkLocationIsNearToStoreAndSave(courierLocationLog);
        } catch (IOException e) {
            throw new RuntimeException("Mesaj dönüştürme hatası!", e);
        }
    }
}