package main.Services;

import main.Entities.Driver;

import java.util.concurrent.ConcurrentHashMap;

public class DriverService {
    private final ConcurrentHashMap<String, Driver> drivers = new ConcurrentHashMap<>();
    private static volatile DriverService instance;

    private DriverService(){} //private constructor to follow singleton pattern

    public static DriverService getInstance(){
        if(instance == null){
            // creating a lock to ensure only one instance is created
            synchronized (DriverService.class){
                if(instance == null){
                    System.out.println("Creating single instance of DriverService");
                    instance = new DriverService();
                }
            }
        }

        return instance;
    }

    public ConcurrentHashMap<String, Driver> getDrivers() {
        return drivers;
    }

    public void addDriver(String key, Driver driverDetails) {
        this.drivers.put(key, driverDetails);
    }
}
