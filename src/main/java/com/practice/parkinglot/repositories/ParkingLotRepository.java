package com.practice.parkinglot.repositories;

import com.practice.parkinglot.models.ParkingLot;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ParkingLotRepository {
    private List<ParkingLot> parkingLots = new ArrayList<>();

    public ParkingLot save(ParkingLot parkingLot) {
        parkingLots.add(parkingLot);
        return parkingLot;
    }

    public List<ParkingLot> findAll() { return parkingLots; }

    public ParkingLot findById(Long id) {
        return parkingLots.stream().filter(parkingLot -> parkingLot.getId().equals(id)).findFirst().orElse(null);
    }
}
