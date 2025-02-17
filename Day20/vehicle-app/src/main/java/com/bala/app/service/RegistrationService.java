package com.bala.app.service;

import com.bala.app.model.Registration;
import com.bala.app.model.Vehicle;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class RegistrationService {
    private Map<String, Registration> registry = new HashMap<>();
            public void registerVehicle(String vehicleNumber, Registration registration) {
        registry.put(vehicleNumber, registration);
            }
            public void deregisterVehicle(String vehicleNumber) {
                registry.remove(vehicleNumber);
            }
            public Map<String, Registration> getRegistry() {
                return registry;
            }

}
