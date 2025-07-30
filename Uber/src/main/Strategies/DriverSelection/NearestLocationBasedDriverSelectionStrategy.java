package main.Strategies.DriverSelection;

import main.Entities.Driver;
import main.Entities.RideMetaData;
import main.Interfaces.IDriverSelectionStrategy;
import main.Services.DriverService;

import java.util.Optional;

public class NearestLocationBasedDriverSelectionStrategy implements IDriverSelectionStrategy {
    private final DriverService driverService;

    public NearestLocationBasedDriverSelectionStrategy(DriverService driverService) {
        this.driverService = driverService;
    }

    @Override
    public Driver matchDriver(RideMetaData rMetadata) {
        var drivers = this.driverService.getDrivers();
        // first check if driver is available or not and then find the driver nearest to riders location
        Optional<Driver> nearestDriver = drivers.values().stream().filter(Driver::isAvailable).min(
                (d1, d2) -> Float.compare(
                        d1.getCurrLocation()
                                .getDistance(rMetadata.getStartLocation()),
                        d2.getCurrLocation()
                                .getDistance(rMetadata.getStartLocation())));

        if (nearestDriver.isEmpty()) {
            throw new RuntimeException("No driver available");
        }

        return nearestDriver.get();
    }
}
