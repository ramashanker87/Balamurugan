package com.bala.app.controller;

import com.bala.app.model.Owner;
import com.bala.app.service.RegistrationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/owner")
public class OwnerController {
    private static final Logger logger = LoggerFactory.getLogger(OwnerController.class);
    @Autowired
    private RegistrationService registrationService;
    @PostMapping("/details")
    public String registerOwner(@RequestBody Owner owner) {
        logger.debug("Owner registered: " + owner);
        return "Owner Registered Successfully";
    }
}
