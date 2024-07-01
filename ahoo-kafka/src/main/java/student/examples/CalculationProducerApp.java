package student.examples;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.protocol.types.Field;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CalculationProducerApp {
    public static void main(String[] args) {

        //settings
        Properties properties = new Properties();
        properties.put("bootstrap.servers", "192.168.215.129:9092");
        properties.put("acks", "all");
        properties.put("retries", 0);
        properties.put("batch.size", 16384);
        properties.put("linger.ms", 1);
        properties.put("buffer.memory", 33554432);
        properties.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        properties.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        final String TOPIC_NAME = "calculation";
        final String KEY = "sample";

        //data
        String data = IntStream.rangeClosed(1, 5).boxed().collect(Collectors.toList()).toString();
        data = data.substring(1,data.length()-1);
        //System.out.println(data);

        //connect and send
        try (Producer<String,String> producer = new KafkaProducer<>(properties)) {
           // create record
            ProducerRecord<String, String> record = new ProducerRecord<>(TOPIC_NAME, KEY, data.toString());
            producer.send(record);
            System.out.println("sent");
        }
    }
}
