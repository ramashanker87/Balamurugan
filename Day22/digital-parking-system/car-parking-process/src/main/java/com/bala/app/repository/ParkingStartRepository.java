package com.bala.app.repository;

import com.bala.app.model.ParkingStart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParkingStartRepository extends JpaRepository<ParkingStart, Integer> {
    ParkingStart findByParkingNo(String parkingNo);
}
