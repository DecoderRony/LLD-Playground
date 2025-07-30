package main.Strategies.Registration;

import main.Entities.Driver;
import main.Entities.RegisterRequest;
import main.Interfaces.IUserStrategy;
import main.Services.DriverService;

public class DriverRegistrationStrategy implements IUserStrategy<Driver> {
    private final DriverService driverService;

    public DriverRegistrationStrategy(DriverService service){
        this.driverService = service;
    }

    @Override
    public Driver registerUser(RegisterRequest userDetails) {
        if(this.driverService.getDrivers().containsKey(userDetails.getPhone())){
            throw new IllegalArgumentException("Driver already registered");
        }


        Driver driver = (Driver)Driver.builder().setName(userDetails.getName()).setPassword(userDetails.getPassword()).setPhone(userDetails.getPhone()).build();
        this.driverService.addDriver(userDetails.getPhone(), driver);
        return driver;
    }

    @Override
    public Driver getUser(String phone) {
        var drivers = this.driverService.getDrivers();

        if(!drivers.containsKey(phone)){
            throw new IllegalArgumentException("Rider not registered");
        }

        return drivers.get(phone);
    }
}
