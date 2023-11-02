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
You can convert these commands into a Markdown (MD) file by simply formatting them as code blocks within your document. Here's how you can present these commands in your README.md file:

## Apache Kafka Commands

### Start the ZooKeeper

To start the ZooKeeper server, use the following command:

```bash
bin\windows\zookeeper-server-start.bat config\zookeeper.properties
```

### Start the Kafka Server

To start the Kafka server, execute the following command:

```bash
bin\windows\kafka-server-start.bat config\server.properties
```

### Create a Topic

Create a Kafka topic using the following command. Replace `quickstart-events` with your desired topic name and adjust the `--bootstrap-server` parameter if needed:

```bash
bin\windows\kafka-topics.bat --create --topic quickstart-events --bootstrap-server localhost:9092
```

### Create a Producer Tool

Use the Kafka console producer to produce messages to a topic. Replace `quickstart-events` with the desired topic name and adjust the `--bootstrap-server` parameter if needed:

```bash
bin\windows\kafka-console-producer.bat --topic quickstart-events --bootstrap-server localhost:9092
```

### Create a Consumer Tool

To consume messages from a Kafka topic, use the following command. Replace `quickstart-events` with the topic name and set `--from-beginning` if you want to start from the beginning of the topic:

```bash
bin\windows\kafka-console-consumer.bat --topic quickstart-events --from-beginning --bootstrap-server localhost:9092
```

Make sure you have Apache Kafka properly installed and configured before running these commands.

## Acknowledgments
- [Apache Kafka Documentation](https://kafka.apache.org/documentation/)

Happy coding!
