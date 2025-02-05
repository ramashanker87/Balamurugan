package com.bala.app.service;

import com.bala.app.model.Patient;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class PatientService {
    Map<String, Patient> patients = new HashMap<>();

    public Map<String, Patient> readAllPatient() {
            return patients;
    }

    public Patient createPatient(Patient patient) {
        patients.put(patient.getId(), patient);
        return patient;
    }

    public Patient updatePatient(String patientId, String hospitalName) {
    Patient patient1 = patients.get(patientId);
    patient1.setHospitalName(hospitalName);
    return patient1;
    }

    public void deletePatient(String id) {
        patients.remove(id);
    }
    public Patient readPatientByName(String Name) {
        Patient result = patients.get(Name);
        return result;
    }
}

