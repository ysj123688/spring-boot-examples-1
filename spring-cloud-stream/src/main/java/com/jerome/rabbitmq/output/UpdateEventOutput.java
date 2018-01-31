package com.jerome.rabbitmq.output;

import com.jerome.rabbitmq.model.UpdateEventDto;

import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.messaging.handler.annotation.Headers;

import java.util.Map;

/**
 * 消息发布
 *
 * @author suzhida
 * @since 2018/1/31 14:57
 */
@MessagingGateway
public interface UpdateEventOutput {

    @Gateway(requestChannel = UpdateEventSinkSource.TEST_USER_EVENT_OUTPUT)
    void publishEvent(@Headers Map<String, Object> headers, UpdateEventDto event);

}
