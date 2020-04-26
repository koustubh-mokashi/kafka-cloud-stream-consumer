package com.example.test.kafkacloudstreamconsumer.sink;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.SubscribableChannel;

public interface EventSink extends Sink {

	/**
	 * Input channel name.
	 */
	String INPUT = "events";

	/**
	 * @return input channel.
	 */
	@Input(EventSink.INPUT)
	SubscribableChannel events();
}
