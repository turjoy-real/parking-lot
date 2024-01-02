package com.practice.parkinglot.models;

import java.time.LocalDateTime;
import java.util.Date;

public class Ticket extends BaseModel {
    private Long vehicleId;
    private LocalDateTime entryTime;
    private Long spotId;
}


