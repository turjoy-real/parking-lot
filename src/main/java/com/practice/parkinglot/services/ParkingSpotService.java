package com.practice.parkinglot.services;

import com.practice.parkinglot.models.ParkingLot;
import com.practice.parkinglot.models.ParkingSpot;
import com.practice.parkinglot.models.VehicleType;
import com.practice.parkinglot.repositories.ParkingSpotRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class ParkingSpotService {
//    public createParkingSpot
   private ParkingSpotRepository parkingSpotRepository = new ParkingSpotRepository();

   public ParkingSpot allocateSlot(Long parkingLotId, VehicleType vehicleType){
       return parkingSpotRepository.findOneByVehicleTypeAndStatusAvailable(vehicleType);
   }

   public ParkingSpot update(ParkingSpot filledSpot) {
       return parkingSpotRepository.update((filledSpot));
   }

   public void createParkingSpots(ParkingLot lot) {
       List<ParkingSpot> parkingSpots = lot.getFloors()
               .stream()
               .flatMap(floor -> floor.getSpots().stream())
               .collect(Collectors.toList());
       parkingSpotRepository.saveAll(parkingSpots);
   }

   public List<ParkingSpot> getParkingSpots(Long id) {
       return parkingSpotRepository.findAllByParkingLotId(id);
   }

   public ParkingSpot getParkingSpot(Long id) {
       return parkingSpotRepository.findOneById(id);
   }
}
