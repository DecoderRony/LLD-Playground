package main.Managers;

import main.Entities.*;
import main.Enums.RideStatus;
import main.Interfaces.IDriverSelectionStrategy;
import main.Interfaces.IPricingStrategy;
import main.Services.DriverService;

public class RideManager {
    private final DriverService driverService;
    private static volatile RideManager instance;

    private RideManager(DriverService service) {
        this.driverService = service;
    } // private constructor to follow singleton pattern

    public static RideManager getInstance(DriverService service){
        if(instance == null){
            // adding lock
            synchronized (RideManager.class){
                if(instance == null){
                    System.out.println("Creating single instance of RideManager");
                    instance = new RideManager(service);
                }
            }
        }
        return instance;
    }

    public Ride bookRide(Rider riderDetails, Location destination) {
        //1. create ride metadata
        var rideMeta = RideMetaData.builder()
                .setStartLocation(riderDetails.getCurrLocation())
                .setEndLocation(destination).build();

        //2. create driver allocation and pricing manager instance
        var driverAllocationAndPricingManager = DriverAllocationAndPricingManager.getInstance(this.driverService);
        //3. get driver allocation strategy
        IDriverSelectionStrategy driverSelectionStrategy = driverAllocationAndPricingManager.determineDriverSelectionStrategy();
        //4. get pricing strategy
        IPricingStrategy pricingStrategy = driverAllocationAndPricingManager.determinePricingStrategy();

        // match driver and get price
        Driver matchedDriver = driverSelectionStrategy.matchDriver(rideMeta);
        matchedDriver.setAvailable(false); // as the driver is matched he's no more available till ride ends
        float price = pricingStrategy.calculatePrice(rideMeta);

        return new Ride(riderDetails, matchedDriver, riderDetails.getCurrLocation(), destination, price, RideStatus.BOOKED);
    }
}
