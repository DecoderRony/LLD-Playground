package main.Managers;

import main.Interfaces.IDriverSelectionStrategy;
import main.Interfaces.IPricingStrategy;
import main.Services.DriverService;
import main.Strategies.DriverSelection.NearestLocationBasedDriverSelectionStrategy;
import main.Strategies.Pricing.DistanceBasedPricingStrategy;

public class DriverAllocationAndPricingManager {
    private final DriverService driverService;
    private static volatile DriverAllocationAndPricingManager instance;

    private DriverAllocationAndPricingManager(DriverService service){
        this.driverService = service;
    } // marking it private to follow singleton pattern

    public static DriverAllocationAndPricingManager getInstance(DriverService service){
        if(instance == null){
            // creating a lock to ensure only one instance is created
            synchronized (DriverAllocationAndPricingManager.class){
                if(instance == null){
                    System.out.println("Creating single instance of DriverAllocationAndPricingManager");
                    instance = new DriverAllocationAndPricingManager(service);
                }
            }
        }

        return instance;
    }

    public IPricingStrategy determinePricingStrategy() {
        return new DistanceBasedPricingStrategy();
    }

    public IDriverSelectionStrategy determineDriverSelectionStrategy() {
        return new NearestLocationBasedDriverSelectionStrategy(this.driverService);
    }
}