package com.example.migros.service;

import com.example.migros.model.CourierStoreEntry;
import com.example.migros.repository.CourierStoreEntryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class CourierStoreEntryService {

    private final CourierStoreEntryRepository courierStoreEntryRepository;

    public void addCourierStoreEntry(CourierStoreEntry entry) {
        courierStoreEntryRepository.save(entry);
    }

    public LocalDateTime getLastEntryTime(Long courierId, Long storeId) {
        CourierStoreEntry lastEntry = courierStoreEntryRepository.findTopByCourierIdAndStoreIdOrderByEntryTimeDesc(courierId, storeId);
        return lastEntry != null ? lastEntry.getEntryTime() : null;
    }

}
