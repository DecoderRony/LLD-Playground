package main.Entities;

import main.Enums.RideStatus;

import java.util.Date;

public class Ride {
    private final Rider riderDetails;
    private final Driver driverDetails;
    private final Location pickupLocation;
    private final Location dropLocation;
//    private final Date pickupTime;
//    private final Date dropTime;
    private final Float estimatedFare;
    private final RideStatus status;

    public Ride(Rider riderDetails, Driver driverDetails, Location pickupLocation, Location dropLocation, Float estimatedFare, RideStatus status) {
        this.riderDetails = riderDetails;
        this.driverDetails = driverDetails;
        this.pickupLocation = pickupLocation;
        this.dropLocation = dropLocation;
        this.estimatedFare = estimatedFare;
        this.status = status;
    }

    public Rider getRiderDetails() {
        return riderDetails;
    }

    public Driver getDriverDetails() {
        return driverDetails;
    }

    public Location getPickupLocation() {
        return pickupLocation;
    }

    public Location getDropLocation() {
        return dropLocation;
    }

//    public Date getPickupTime() {
//        return pickupTime;
//    }
//
//    public Date getDropTime() {
//        return dropTime;
//    }

    public Float getEstimatedFare() {
        return estimatedFare;
    }

    public RideStatus getStatus() {
        return status;
    }
}
