package com.rentcloud.vehicleservice.service;

import com.rentcloud.model.Vehicle;

import java.util.List;

public interface VehicleService {

    Vehicle save(Vehicle vehicle);

    Vehicle fetchById(int id);

    List<Vehicle> fetchAll();
}
