package com.bala.app.listener;

import org.apache.logging.log4j.message.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
public class ParkingListener {
    private static final Logger logger = LoggerFactory.getLogger(ParkingListener.class);
    @Bean
    public Jackson2JsonMessageConverter jackson2JsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }
    @RabbitListener(queues = {"${rabbitmq.parkingStart.queue.name}"})
    public void receiveParkingStart(String message) {
        logger.info("Received parking start message {} %s", message.toString());
        //logger.info("Received parking start message");
    }
@RabbitListener(queues = {"${rabbitmq.parkingEnd.queue.name}"})
    public void receiveParkingEnd(String message) {
    //logger.info("Received parking end message");
        logger.info("Received parking end message {} %s", message.toString());
}
}