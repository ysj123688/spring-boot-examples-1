package com.jerome;

import com.jerome.rabbitmq.model.UpdateEventDto;
import com.jerome.rabbitmq.output.UpdateEventOutput;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author suzhida
 * @since 2017/7/19 10:14
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class EventPublishTest {

    @Autowired
    private UpdateEventOutput updateEventOutput;

    @Test
    public void testPulishMessage() throws Exception {
        UpdateEventDto dto = new UpdateEventDto();
        dto.setAge(12);
        dto.setName("jerome");
        updateEventOutput.publishEvent(null, dto);
    }

}
