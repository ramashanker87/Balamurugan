package com.bala.app.controller;


import com.bala.app.model.Patient;
import com.bala.app.service.PatientService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.HashMap;
import java.util.Map;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class PatientControllerTest {
    @InjectMocks
    PatientController patientController;
    @Mock
    PatientService patientService;
@Test
public void testgetallpatients() {
    Map<String, Patient> patientMap = new HashMap<>();
    Patient patient1 = new Patient("patient1", "p1", "hospitalName", 55, "M");


}

}

