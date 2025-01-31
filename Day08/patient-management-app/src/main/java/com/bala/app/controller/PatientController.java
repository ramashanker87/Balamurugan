package com.bala.app.controller;

import com.bala.app.model.Patient;
import com.bala.app.service.PatientService;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/patient")
public class PatientController {
    private final PatientService patientService;

public PatientController(PatientService patientService) {
    this.patientService = patientService;
}

@GetMapping("/age/all")
public Map<String, Patient> getAllPatients() {
    return PatientService.readAllPatient();
}
@PostMapping("/save")
    public Patient savePatient(@RequestBody Patient patient) {
    return PatientService.createPatient(patient);
}
@PutMapping("/update")
    public Patient updatePatient(@RequestParam("hospitalName") String hospitalName, @RequestParam("id") String patientId) {
    return PatientService.updatePatient(hospitalName,patientId);
}
@DeleteMapping("/delete")
    public void deletePatient(@RequestParam("id") String patientId) {
    patientService.deletePatient(patientId);
}
}
