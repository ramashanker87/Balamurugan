package com.bala.app.controller;

import com.bala.app.module.Patient;
import com.bala.app.service.PatientService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController

public class PatientController {
    private final PatientService patientService;
    private final ObjectMapper objectMapper;
    public PatientController(PatientService patientService, ObjectMapper objectMapper) {
        this.patientService = patientService;
        this.objectMapper = objectMapper;
    }
    @PostMapping("/send")
    public String sendMessage(@RequestBody Patient patient, @RequestHeader("fever") String disease) throws JsonProcessingException {
        Map<String, Object> headers = new HashMap<>();
        String correlationId = UUID.randomUUID().toString();
        headers.put("fever", disease);
        headers.put("correlationId", correlationId);
        String requestMessage = objectMapper.writeValueAsString(patient);
        patientService.sendMessage(requestMessage, headers);
        return disease;
    }


}
