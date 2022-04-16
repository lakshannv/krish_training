package com.rentcloud.vehicleservice.service;

import com.rentcloud.model.Vehicle;
import com.rentcloud.vehicleservice.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleServiceImpl implements VehicleService {

    @Autowired
    VehicleRepository vehicleRepository;

    @Override
    public Vehicle save(Vehicle vehicle) {
        return vehicleRepository.save(vehicle);
    }
    @Override
    public Vehicle fetchById(int id) {
        Optional<Vehicle> customer = vehicleRepository.findById(id);
        if (customer.isPresent()) {
            return customer.get();
        } else {
            return null;
        }
    }

    @Override
    public List<Vehicle> fetchAll() {
        return vehicleRepository.findAll();
    }
}
