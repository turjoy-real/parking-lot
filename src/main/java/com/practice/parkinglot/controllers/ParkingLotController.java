package com.practice.parkinglot.controllers;

import com.practice.parkinglot.dtos.CreateParkingLotRequest;
import com.practice.parkinglot.models.ParkingLot;
import com.practice.parkinglot.services.ParkingLotService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

// Step 1 - Add REST controller annotations
@RestController
@RequestMapping("/api/v1/parking-lot")
@AllArgsConstructor// Step 2 - Map all requests for this URL to this controller
public class ParkingLotController {

    private ParkingLotService parkingLotService;

    // Create a parking lot
    // POST

    // 1. Request validation
    // 2. Data transformation

    // POST /api/v1/parking-lot
    @PostMapping
    public ParkingLot createParkingLot(@RequestBody CreateParkingLotRequest request) {
        validate(request);
        ParkingLot parkingLot = transform(request);
        return parkingLotService.create(parkingLot);
    }


    // GET /api/v1/parking-lot/{id}
    @GetMapping("/{id}") // Step 3 - Add method level mapping
    public ParkingLot getParkingLot(@PathVariable("id") Long id) { // Step 4 - Add path variable
        return ParkingLot.builder().build();
    }

    private void validate(CreateParkingLotRequest request) {
        if (request.getNumberOfFloors() == null) {
            throw new RuntimeException(("Invalid number of floors"));
        }
    }

    private ParkingLot transform(CreateParkingLotRequest request) {
        return request.toParkingLot();
    }

}

