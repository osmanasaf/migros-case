package com.example.migros.controller;

import com.example.migros.model.Courier;
import com.example.migros.model.GeoLocation;
import com.example.migros.service.CourierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/courier")
public class CourierController {

    private final CourierService courierService;

    @Autowired
    public CourierController(CourierService courierService) {
        this.courierService = courierService;
    }

    @PostMapping
    public ResponseEntity<Courier> addCourier(@RequestBody Courier courier) {
        Courier newCourier = courierService.addCourier(courier);
        return ResponseEntity.status(201).body(newCourier);
    }

    @PutMapping("/{courierId}/location")
    public ResponseEntity<Courier> updateCourierLocation(@PathVariable Long courierId, @RequestBody GeoLocation location) {
        Courier updatedCourier = courierService.updateCourierLocation(courierId, location);
        return ResponseEntity.ok(updatedCourier);
    }

    @GetMapping("/{courierId}")
    public ResponseEntity<Courier> getCourierById(@PathVariable Long courierId) {
        Courier courier = courierService.getCourierById(courierId);
        return ResponseEntity.ok(courier);
    }

    @GetMapping("/{courierId}/distance")
    public ResponseEntity<Double> getTotalTravelDistance(@PathVariable Long courierId) {
        double distance = courierService.getTotalTravelDistance(courierId);
        return ResponseEntity.ok(distance);
    }
}
