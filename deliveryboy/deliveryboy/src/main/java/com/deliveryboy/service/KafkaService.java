package com.deliveryboy.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import static com.deliveryboy.config.AppConstants.LOCATION_UPDATE_TOPIC;

@Service
public class KafkaService {
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    private Logger logger = LoggerFactory.getLogger(KafkaService.class);

    public boolean updateLocation(String location) {
        this.logger.info("Location Produced");
        this.kafkaTemplate.send(LOCATION_UPDATE_TOPIC, location);
        return true;
    }
}
