package com.company;

import org.springframework.stereotype.Component;

@Component
public class MessageListener {

    private final static String MESSAGE_QUEUE = "messageQueue";

    //    @JmsListener(destination = MESSAGE_QUEUE, containerFactory = "jmsFactory")
//    @JmsListener(destination = MESSAGE_QUEUE)
    public void receiveMessage(String message) {
        System.out.println(message);
    }
}
