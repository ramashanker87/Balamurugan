package com.bala.app.listener;

import com.bala.app.model.Car;
import com.bala.app.model.ParkingEnd;
import com.bala.app.model.ParkingStart;
import com.bala.app.repository.CarRepository;
import com.bala.app.repository.ParkingEndRepository;
import com.bala.app.repository.ParkingStartRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.message.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Map;

@Service
public class ParkingListener {
   @Autowired
   private CarRepository carRepository;
   @Autowired
   private ParkingStartRepository parkingStartRepository;
   @Autowired
   private ParkingEndRepository parkingEndRepository;




    private static final Logger logger = LoggerFactory.getLogger(ParkingListener.class);
    @Bean
    public Jackson2JsonMessageConverter jackson2JsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }
    @RabbitListener(queues = {"${rabbitmq.parkingStart.queue.name}"})
    public void receiveParkingStart(Map<String, Object> message) {
        logger.info("Received parking start message {} %s", message.toString());
        //logger.info("Received parking start message");

        ObjectMapper objectMapper = new ObjectMapper();
        // Extract car object
        Car car = objectMapper.convertValue(message.get("car"), Car.class);
        String parkingNo = (String) message.get("parkingNo");
        if (car == null || parkingNo == null) {
            logger.error("Invalid message received: " + message);
            return;
        }

        logger.info("Processing parking start request for car: " + car + " at parking number: " + parkingNo);

        // Save car details
        carRepository.save(car);
        ParkingStart start = new ParkingStart();
        start.setStartTime(LocalDateTime.now());
        start.setRegNo(car.getRegNo());
        start.setStatus("Parked");
        start.setParkingNo(parkingNo);

        parkingStartRepository.save(start);

        String responseMessage = "Response - Hello " + car.getOwnerName() + ", your car " +
                car.getRegNo() + " is parked successfully at " + start.getStartTime();



    }
@RabbitListener(queues = {"${rabbitmq.parkingEnd.queue.name}"})
    public void receiveParkingEnd(String parkingNo) {
    //logger.info("Received parking end message");
        //logger.info("Received parking end message {} %s", message.toString());
    logger.info("Processing parking end request for number: " + parkingNo);
    // first calculate end time and push into DB

    ParkingStart start = parkingStartRepository.findByParkingNo(parkingNo);
   // if (start.getRegNo()==Null)
   // System.out.println(start.getRegNo());
    Car car = carRepository.findByregNo(start.getRegNo());


    //save into parking end

    ParkingEnd end = new ParkingEnd();
    end.setEndTime(LocalDateTime.now());
    end.setRegNo(start.getRegNo());
    end.setStartTime(start.getStartTime());
    end.setStatus("NOT PARKED");
    end.setParkingNo(parkingNo);
    long time =(int) ChronoUnit.SECONDS.between(end.getStartTime(),end.getEndTime());

    int timeInMinutes = (int) Math.ceil(time / 60.0);


    end.setPrice(timeInMinutes * 2);
    parkingEndRepository.save(end);

    carRepository.delete(car);
    parkingStartRepository.delete(start);
    // Simulating processing logic
    String responseMessage = "Response - Parking ended for number: " + parkingNo
            + ". Cost to be collected for " + timeInMinutes + " minutes is Rs " + end.getPrice();;

}
}