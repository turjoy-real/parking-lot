package com.practice.parkinglot.repositories;

import com.practice.parkinglot.models.ParkingSpot;
import com.practice.parkinglot.models.SpotStatus;
import com.practice.parkinglot.models.VehicleType;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ParkingSpotRepository {
    private List<ParkingSpot> parkingSpots = new ArrayList<>();

    public ParkingSpot save(ParkingSpot parkingSpot) {
        parkingSpots.add(parkingSpot);
        return parkingSpot;
    }

    public ParkingSpot findOneByVehicleTypeAndStatusAvailable(VehicleType type) {

        for (ParkingSpot parkingSpot : parkingSpots) {

            if (parkingSpot.getSpotStatus() ==  SpotStatus.AVAILABLE && parkingSpot.getVehicleType() == type) {
                return parkingSpot;
            }
        }

        return null;
    }

    public ParkingSpot update(ParkingSpot filledSpot) {

        ParkingSpot currentSpot = parkingSpots
                .stream()
                .filter(spot -> spot.getId().equals(filledSpot.getId()))
                .findFirst()
                .get();

        if (currentSpot == null) {
            throw new RuntimeException("Invalid Parking Spot");
        }

        parkingSpots.remove(currentSpot);
        parkingSpots.add(filledSpot);

        return filledSpot;
    }

    public void saveAll(List<ParkingSpot> sports) {
        System.out.println(("Parking Spots: " + sports));
        parkingSpots.addAll(sports);
        System.out.println("Parking Spots: " + parkingSpots);
    }

    public List<ParkingSpot> findAllByParkingLotId(Long id) {return parkingSpots;}

    public ParkingSpot findOneById(Long id) {
        return parkingSpots
                .stream()
                .filter(spot -> spot.getId().equals(id))
                .findFirst()
                .get();
    }

}
