package com.jerome.rabbitmq.input;

import com.jerome.rabbitmq.model.UpdateEventDto;
import com.jerome.rabbitmq.output.UpdateEventSinkSource;

import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

/**
 * 消息接收
 *
 * @author suzhida
 * @since 2018/1/31 14:58
 */
@Service
@Slf4j
public class UpdateEventInput {

    @StreamListener(UpdateEventSinkSource.TEST_USER_EVENT_INPUT)
    public void process(UpdateEventDto event) {
        log.info("process event, event = {}", event);
    }

}
