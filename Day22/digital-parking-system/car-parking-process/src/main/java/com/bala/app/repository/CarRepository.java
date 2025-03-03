package com.bala.app.repository;

import com.bala.app.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Integer> {
    Car findByregNo(String parkingNo);
}
