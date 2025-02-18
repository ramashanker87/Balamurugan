package com.bala.app.controller;

import com.bala.app.model.Car;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/parking")
public class ParkingController {
    private static final Logger logger = LoggerFactory.getLogger(ParkingController.class);
    @PostMapping("/start")
    public String startParking(@RequestBody Car car, @RequestParam String parkingNo) {
        logger.info("Starting Parking System");
        return "Parking started";
        //return car;
    }
}
