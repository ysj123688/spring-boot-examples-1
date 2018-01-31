package com.jerome.rabbitmq.output;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface UpdateEventSinkSource {

    String TEST_USER_EVENT_INPUT = "test_user_event_input";
    String TEST_USER_EVENT_OUTPUT = "test_user_event_output";

    @Input(TEST_USER_EVENT_INPUT)
    SubscribableChannel subscribableChannel();

    @Output(TEST_USER_EVENT_OUTPUT)
    MessageChannel messageChannel();

}
