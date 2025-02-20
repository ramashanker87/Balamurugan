package com.bala.app.config;

import jdk.jfr.Category;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {
    @Value("parking-start-request.out")
    private String parkingStartQueueName;
    @Value("parking.exchange")
    private String exchangeName;
    @Value("parkingStart.routingkey")
    private String routingKey;

    @Value("parking-end-request.out")
    private String parkingEndQueueName;
    @Value("parkingEnd.routingkey")
    private String routingEndKey;

    @Bean
    public Queue parkingStartQueue() {
        return new Queue(parkingStartQueueName,true){};
    }
    @Bean
    public Queue parkingEndQueue() {
        return new Queue(parkingEndQueueName,true){};
    }
    @Bean
    public DirectExchange parkingExchange() {
        return new DirectExchange(exchangeName);
    };
    @Bean
    public Binding parkingStartBinding(Queue parkingStartQueue, DirectExchange exchange) {
        return BindingBuilder.bind(parkingStartQueue).to(exchange).with(routingKey);
    }
    @Bean
    public Binding parkingEndBinding(Queue parkingEndQueue, DirectExchange exchange) {
        return BindingBuilder.bind(parkingEndQueue).to(exchange).with(routingEndKey);
    }
    @Bean
    public Jackson2JsonMessageConverter JsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }
    @Bean
    public AmqpTemplate amqpTemplate(ConnectionFactory connectionFactory) {
        final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMandatory(true);
        rabbitTemplate.setMessageConverter(JsonMessageConverter());
        return rabbitTemplate;
    }
}
