package com.company;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

public class MessageSender {

    /**
     * failover://tcp://localhost:61616
     */
    private final static String URL = ActiveMQConnection.DEFAULT_BROKER_URL;

    private final static String MESSAGE_QUEUE = "messageQueue";

    public void sendMessage() {
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(URL);

        try {
            Connection connection = connectionFactory.createConnection();
            connection.start();

            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

            Destination destination = session.createQueue(MESSAGE_QUEUE);

            MessageProducer producer = session.createProducer(destination);
            TextMessage message1 = session.createTextMessage("Hello world");
            TextMessage message2 = session.createTextMessage("Hello");

            producer.send(message1);
            producer.send(message2);

            connection.close();

        } catch (JMSException e) {
            throw new RuntimeException("Shlapa kakaya-to");
        }
    }


}
