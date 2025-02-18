package com.bala.app.service;

import com.bala.app.model.Car;
import com.bala.app.model.ParkingEnd;
import com.bala.app.model.ParkingStart;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class ParkingService {
    //private static Map<String, ParkingStart> parkingStartStorage = new HashMap<>();
public ParkingStart startParking(Car car, String parkingNo){

    ParkingStart parkingStart = new ParkingStart();
    parkingStart.setParkingNo(parkingNo);
    parkingStart.setStartTime(new Date());
    parkingStart.setStatus("Start");
    parkingStart.setRegNo(car.getRegNo());
   // parkingStartStorage.put(parkingNo, parkingStart);
    return parkingStart;
}

    public ParkingEnd endParking(String regNo) {
//ParkingStart parkingStart = parkingStartStorage.get(regNo);
        ParkingStart parkingstart= new ParkingStart();
    ParkingEnd parkingEnd = new ParkingEnd();
    parkingEnd.setRegNo(regNo);
    System.out.println(parkingEnd.getRegNo());
    parkingEnd.setStatus("End");
    parkingEnd.setEndTime(new Date());
//    Date testDate = parkingStart.getStartTime();
//    System.out.println(testDate);
    parkingEnd.setStartTime(parkingstart.getStartTime());
    parkingEnd.setParkingNo(parkingstart.getParkingNo());

//    long timeDiff = parkingEnd.getEndTime().getTime() - parkingEnd.getStartTime().getTime();
//    long minutes = timeDiff / 60000;
//    parkingEnd.setPrice((int) (minutes*2));
    return parkingEnd;

    }
}
