package com.company;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.Session;
import javax.jms.TextMessage;

public class MyMessageConsumer {

    /**
     * failover://tcp://localhost:61616
     */
    private final static String URL = ActiveMQConnection.DEFAULT_BROKER_URL;

    private final static String MESSAGE_QUEUE = "messageQueue";

    public void getMessage() {
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(URL);

        try {
            Connection connection = connectionFactory.createConnection();
            connection.start();

            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

            Destination destination = session.createQueue(MESSAGE_QUEUE);

            MessageConsumer consumer = session.createConsumer(destination);

            while (true) {
                TextMessage message = (TextMessage) consumer.receive();
                System.out.println(message);
            }

        } catch (JMSException e) {
            throw new RuntimeException("Shlapa kakaya-to");
        }
    }

}
