package com.example.cloudcatalogservice.queue;

import com.example.cloudcatalogservice.jpa.CatalogEntity;
import com.example.cloudcatalogservice.jpa.CatalogRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.netflix.discovery.converters.Auto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@Slf4j
public class KafkaConsumer {

    @Autowired
    CatalogRepository repository;

    @KafkaListener(topics = "example-catalog-topic")
    public void processMessage(String kafkaMessage) {

        log.info("kafka messge ==>> " + kafkaMessage);
        Map<Object,Object> map = new HashMap<>();
        ObjectMapper mapper = new ObjectMapper();

        try {
            map = mapper.readValue(kafkaMessage, new TypeReference<>() {});
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        CatalogEntity entity = repository.findByProductId((String)map.get("productId"));
        entity.setStock(entity.getStock() - (Integer)map.get("qty"));
        repository.save(entity);
    }
}
