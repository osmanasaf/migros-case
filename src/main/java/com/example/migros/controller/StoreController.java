package com.example.migros.controller;

import com.example.migros.model.Store;
import com.example.migros.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/stores")
public class StoreController {

    private final StoreService storeService;

    @Autowired
    public StoreController(StoreService storeService) {
        this.storeService = storeService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Store>> getAllStores() {
        List<Store> stores = storeService.getAllStores();
        return ResponseEntity.ok(stores);
    }

    @GetMapping("/nearby")
    public ResponseEntity<List<Store>> getNearbyStores(@RequestParam Double latitude, @RequestParam Double longitude) {
        List<Store> nearbyStores = storeService.getNearbyStores(latitude, longitude);
        return ResponseEntity.ok(nearbyStores);
    }
}
