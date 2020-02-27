package com.company;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.jms.ConnectionFactory;

@Configuration
public class Config {

    private final static String MESSAGE_QUEUE = "messageQueue";
    private final static String URL = ActiveMQConnection.DEFAULT_BROKER_URL;

    @Bean
    public ConnectionFactory connectionFactory() {
        return new ActiveMQConnectionFactory(URL);
    }

//    @Bean
//    public JmsTemplate jmsTemplate() {
//        return new JmsTemplate(connectionFactory());
//    }

//    @Bean
//    public JmsListenerContainerFactory jmsFactory(ConnectionFactory connectionFactory, DefaultJmsListenerContainerFactoryConfigurer configurer) {
//        DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
//
//        configurer.configure(factory, connectionFactory);
//
//        return factory;
//    }
}
