package KafkaTest;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;

import java.util.Collections;
import java.util.Properties;

public class KafkaConsumerTest {
    public static void main(String[] args) {
        // Configure Kafka consumer properties
        Properties properties = new Properties();
        properties.setProperty(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        properties.setProperty(ConsumerConfig.GROUP_ID_CONFIG, "my-consumer-group");
        properties.setProperty(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        properties.setProperty(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());

        // Create a Kafka consumer
        try (KafkaConsumer<String, String> consumer = new KafkaConsumer<>(properties)) {
            // Subscribe to the topic(s)
            consumer.subscribe(Collections.singletonList("my_topic"));

            while (true) {
                // Poll for new messages
                ConsumerRecords<String, String> records = consumer.poll(100);

                // Process the received records
                records.forEach(record -> {
                    System.out.printf("Received message: key = %s, value = %s%n", record.key(), record.value());
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
