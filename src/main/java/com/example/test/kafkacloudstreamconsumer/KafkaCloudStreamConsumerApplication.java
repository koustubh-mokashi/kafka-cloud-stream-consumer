package com.example.test.kafkacloudstreamconsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;

import com.example.test.kafkacloudstreamconsumer.sink.EventSink;

@SpringBootApplication
@EnableBinding(EventSink.class)
public class KafkaCloudStreamConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(KafkaCloudStreamConsumerApplication.class, args);
	}

    @StreamListener(EventSink.INPUT)
    public void listen(@Payload String in, @Header(KafkaHeaders.RECEIVED_PARTITION_ID) int partition) {
        System.out.println(in + " received from partition " + partition);
    }

//	@Bean
//	public java.util.function.Consumer<KStream<Object, String>> magical() {
//		return input -> input.foreach((key, value) -> {
//			System.out.println("Key: " + key + " Value: " + value);
//		});
//	}

}
