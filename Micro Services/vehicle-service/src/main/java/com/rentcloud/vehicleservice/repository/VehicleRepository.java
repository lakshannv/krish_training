package com.rentcloud.vehicleservice.repository;

import com.rentcloud.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleRepository extends JpaRepository<Vehicle, Integer> {

}
