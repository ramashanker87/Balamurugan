package com.bala.app.service;

import com.bala.app.model.Patient;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class PatientService {
    public static Map<String, Patient> patients = new HashMap<String, Patient>();

    public static Map<String, Patient> readAllPatient() {
            return patients;
    }

    public static Patient createPatient(Patient patient) {
        patients.put(patient.getId(), patient);
        return patient;
    }

    public static Patient updatePatient(String newHospitalName, String patientId) {
    Patient patient1 = patients.get(patientId);
    patient1.setHospitalName(newHospitalName);
    return patient1;
    }

    public void deletePatient(String patientId) {
        patients.remove(patientId);
    }
}

