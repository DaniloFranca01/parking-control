package com.api.parkingcontrol.exceptions.vehicles;

public class VehicleNotFoundException extends RuntimeException {

    public VehicleNotFoundException(String message) {
        super(message);
    }
}