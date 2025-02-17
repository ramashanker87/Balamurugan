package com.bala.app.controller;

import com.bala.app.model.Owner;
import com.bala.app.model.Registration;
import com.bala.app.model.Vehicle;
import com.bala.app.service.RegistrationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/register")
public class VehicleController {
    private static final Logger logger = LoggerFactory.getLogger(VehicleController.class);
    @Autowired
    private RegistrationService registrationService;
//    @PostMapping("/vehicle")
//    public String registerVehicle(@RequestBody Vehicle vehicle, @RequestBody Owner owner) {
//        Registration registration = new Registration(owner, vehicle);
//        registrationService.registerVehicle(vehicle.getVehicleNumber(),registration);
//        logger.info("Vehicle registered" + vehicle);
//        return "Vehicle registered successfully!";
//    }
@PostMapping("/vehicle")
public String registerVehicle(@RequestBody Registration registration) {
    registrationService.registerVehicle(registration.getVehicle().getVehicleNumber(), registration);

    // Log at info level for Vehicle registration
    logger.info("Vehicle registered: " + registration.getVehicle());

    return "Vehicle registered successfully!";
}

    @DeleteMapping("/vehicle")
    public String deregisterVehicle(@RequestParam String vehicleNumber) {
        registrationService.deregisterVehicle(vehicleNumber);
        logger.info("Vehicle deregistered" + vehicleNumber);
        return "Vehicle deregistered successfully!";
    }
}
