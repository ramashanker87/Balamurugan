package com.bala.app.repository;

import com.bala.app.model.ParkingStart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParkingRepository extends JpaRepository<ParkingStart, String> {

}
