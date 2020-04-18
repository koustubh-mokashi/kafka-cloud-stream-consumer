package com.example.test.kafkacloudstreamconsumer;

import org.apache.kafka.streams.kstream.KStream;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class KafkaCloudStreamConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(KafkaCloudStreamConsumerApplication.class, args);
	}

	@Bean
	public java.util.function.Consumer<KStream<Object, String>> magical() {
		return input -> input.foreach((key, value) -> {
			System.out.println("Key: " + key + " Value: " + value);
		});
	}

}
