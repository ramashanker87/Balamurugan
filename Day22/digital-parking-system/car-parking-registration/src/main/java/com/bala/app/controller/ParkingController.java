package com.bala.app.controller;

import com.bala.app.model.Car;
import com.bala.app.service.ParkingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
//@Service
@RestController
@RequestMapping("/parking")
public class ParkingController {
    private static final Logger logger = LoggerFactory.getLogger(ParkingController.class);
    @Autowired
    private ParkingService parkingService;

    public ParkingController(ParkingService parkingService) {
        this.parkingService = parkingService;
    }

    @PostMapping("/start")
    public String startParking(@RequestBody Car car, @RequestParam String parkingNo) {
        logger.info("Starting Parking System");
    return parkingService.startParking(car,parkingNo);
        //return parkingService.toString();
        //return car;
    }
    @PostMapping("/end")
    public String endParking(@RequestParam String regNo) {
        logger.info("Ending Parking System");
        return parkingService.endParking(regNo);

    }
}
