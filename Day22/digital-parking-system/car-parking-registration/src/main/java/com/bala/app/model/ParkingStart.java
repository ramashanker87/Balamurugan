package com.bala.app.model;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
import org.springframework.stereotype.Service;

import java.util.Date;
@Service
//@Entity
public class ParkingStart {
//   @Id
//   @GeneratedValue(strategy = GenerationType.AUTO)
//    int id;
    String parkingNo;
     Date startTime;  //(Should always current time)
    String status;  //(Start)
    String regNo; //regNo;

    public String getParkingNo() {
        return parkingNo;
    }

    public void setParkingNo(String parkingNo) {
        this.parkingNo = parkingNo;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public  String getRegNo() {
        return regNo;
    }

    public void setRegNo(String regNo) {
        this.regNo = regNo;
    }
}
