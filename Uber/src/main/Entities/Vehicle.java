package main.Entities;

import main.Enums.VehicleType;

public class Vehicle {
    private final VehicleType type;

    public Vehicle(VehicleType type) {
        this.type = type;
    }

    public VehicleType getType() {
        return type;
    }

}
