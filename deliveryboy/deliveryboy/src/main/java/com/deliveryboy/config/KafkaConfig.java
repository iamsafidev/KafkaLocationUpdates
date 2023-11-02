package com.deliveryboy.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

import static com.deliveryboy.config.AppConstants.LOCATION_UPDATE_TOPIC;

@Configuration
public class KafkaConfig {

    public NewTopic topic(){

        return TopicBuilder
                .name(LOCATION_UPDATE_TOPIC)
                .build() ;

    }
}
