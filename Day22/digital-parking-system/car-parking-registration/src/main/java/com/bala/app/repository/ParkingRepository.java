package com.bala.app.repository;

import com.bala.app.model.ParkingStart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface ParkingRepository extends JpaRepository<ParkingStart, String> {

}
