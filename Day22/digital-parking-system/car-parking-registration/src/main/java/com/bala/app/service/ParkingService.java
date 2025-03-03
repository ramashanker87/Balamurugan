package com.bala.app.service;

import com.bala.app.model.Car;
import com.bala.app.model.ParkingStart;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
//import java.util.logging.Logger;

@Service
public class ParkingService {
    private static final Logger logger = LoggerFactory.getLogger(ParkingService.class);
    private final AmqpTemplate amqpTemplate;

    public ParkingService(AmqpTemplate amqpTemplate, ParkingStart parkingStart) {
        this.amqpTemplate = amqpTemplate;
        this.parkingStart = parkingStart;
    }

    private ParkingStart parkingStart;

//    public ParkingService(AmqpTemplate amqpTemplate, ParkingStart parkingStart) {
//        this.amqpTemplate = amqpTemplate;
//        this.parkingStart = parkingStart;
//    }
    @Value("parking-start-request.out")
    private String parkingStartRequestOut;
    @Value("parking.exchange")
    private String parkingExchange;
    @Value("parkingStart.routingkey")
    private String parkingStartRoutingkey;

    @Value("parking-end-request.out")
    private String parkingEndRequestOut;
    @Value("parkingEnd.routingkey")
    private String parkingEndRoutingkey;




public String startParking(Car car, String parkingNo){
    logger.info("Getting parking number " + parkingNo);
    // Create a Map message
    Map<String, Object> message = new HashMap<>();
    message.put("car", car);
    message.put("parkingNo", parkingNo);

    //ParkingStart parkingStart = new ParkingStart(); //
//    parkingStart.setParkingNo(parkingNo);
//    parkingStart.setStartTime(new Date());
//    parkingStart.setStatus("Start");
//    parkingStart.setRegNo(car.getRegNo());
    logger.info("Parking Start: " + parkingStart.toString());
    amqpTemplate.convertAndSend(parkingExchange, parkingStartRoutingkey, message);
    //return parkingStart;
    return "Let's start Parking......";
}

    public String endParking(String regNo) {

//    ParkingEnd parkingEnd = new ParkingEnd();
//    parkingEnd.setRegNo(regNo);
//    System.out.println(parkingEnd.getRegNo());
//    parkingEnd.setStatus("End");
//    parkingEnd.setEndTime(new Date());
//
//    parkingEnd.setStartTime(parkingStart.getStartTime());
//    parkingEnd.setParkingNo(parkingStart.getParkingNo());
//
//    long timeDiff = parkingEnd.getEndTime().getTime() - parkingEnd.getStartTime().getTime();
//    long minutes = timeDiff / 60000;
//    parkingEnd.setPrice((int) (minutes*2));

    amqpTemplate.convertAndSend(parkingExchange, parkingEndRoutingkey, regNo);
    //return parkingEnd;
        return "Parking is ending...";

    }
}
