package com.company;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JmsController {

    private final static String MESSAGE_QUEUE = "messageQueue";

    @Autowired
    private JmsTemplate jmsTemplate;

    @GetMapping("/{message}")
    public void sendMessage(@PathVariable String message) {
        jmsTemplate.convertAndSend(MESSAGE_QUEUE, message);
    }
}
