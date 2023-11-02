## Kafka Java Spring Boot Project

This project is an example of how to integrate Apache Kafka with a Java Spring Boot application. It demonstrates how to produce and consume messages using Kafka for event-driven architecture.

## Prerequisites

Before you begin, ensure you have met the following requirements:

- Java Development Kit (JDK) 17
- Apache Kafka installed and running
- Apache ZooKeeper (required for Kafka)
- Spring Boot and Apache Kafka dependencies

## Getting Started

Follow these steps to get your Kafka Spring Boot project up and running:

1. Clone this repository to your local machine:

   ```bash
   git clone https://github.com/yourusername/kafka-java-spring-boot.git
   ```

2. Open the project in your favourite Integrated Development Environment (IDE).

3. Configure your Kafka settings in `application.properties` for the producer:

   ```yaml
    spring.kafka.producer.bootstrap-servers=localhost:9092
    spring.kafka.producer.key-serializer=org.apache.kafka.common.serialization.StringSerializer
    spring.kafka.producer.value-serializer=org.apache.kafka.common.serialization.StringSerializer
   ```
4. Configure your Kafka settings in `application.properties` for the consumer:

   ```yaml
    server.port=8081
    spring.kafka.consumer.bootstrap-servers=localhost:9092
    spring.kafka.consumer.group-id=group-1
    spring.kafka.consumer.auto-offset-reset=earliest
    spring.kafka.consumer.key-deserializer=org.apache.kafka.common.serialization.StringDeserializer
    spring.kafka.consumer.value-deserializer=org.apache.kafka.common.serialization.StringDeserializer
   ```

5. Implement your Kafka producers and consumers in the Java classes provided in the project.


Your Kafka Spring Boot application is now up and running.

## Usage

### Producing Messages

```java
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
```

### Consuming Messages

```java
@Configuration
public class KafkaConsumerConfig {
    @KafkaListener(topics = AppConstants.LOCATION_UPDATE_TOPIC, groupId = AppConstants.GROUP_ID)
    public void updatedLocation(String value) {
        System.out.println(value);
    }
}
```


## Acknowledgments
- [Apache Kafka Documentation](https://kafka.apache.org/documentation/)

Happy coding!
