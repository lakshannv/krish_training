package com.rentcloud.vehicleservice.controller;

import com.rentcloud.model.Vehicle;
import com.rentcloud.vehicleservice.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/services")
public class VehicleController {

    @Autowired
    VehicleService vehicleService;

    @RequestMapping(value = "/vehicle", method = RequestMethod.POST)
    public Vehicle save(@RequestBody Vehicle vehicle) {
        return vehicleService.save(vehicle);
    }

    @RequestMapping(value = "/vehicle", method = RequestMethod.GET)
    public ResponseEntity<Vehicle> fetchById(@RequestParam int id) {
        Vehicle vehicle = vehicleService.fetchById(id);
        if (vehicle == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(vehicle);
        }
    }

    @RequestMapping(value = "/vehicles", method = RequestMethod.GET)
    public List<Vehicle> fetchAll() {
        return vehicleService.fetchAll();
    }
}