package test.ServiceTests;

import main.Entities.Driver;
import main.Entities.Location;
import main.Entities.Vehicle;
import main.Enums.VehicleType;
import main.Services.DriverService;

public class DriverServiceTest {
    public static void main(String[] args) {
        var driverService = DriverService.getInstance();
        driverService.getDrivers().clear(); // reset state before each test

        driverService.addDriver("1", new Driver("Arpit", "1234567890", "arpit@example.com", new Location(10,20), new Vehicle(VehicleType.SEDAN), 5, true));
        driverService.addDriver("2", new Driver("Rahul", "9876543210", "rahul@example.com", new Location(40,80), new Vehicle(VehicleType.SEDAN), 4, true));
        driverService.addDriver("3", new Driver("Sameer", "1111111111", "sameer@example.com", new Location(5,90), new Vehicle(VehicleType.SEDAN), 1, true));

        // Assert the size of drivers map is 3
        assert driverService.getDrivers().size() == 3 : "Expected 3 drivers in the service";

        // Assert each driver is present with correct key
        assert driverService.getDrivers().containsKey("1") : "Driver with key '1' should exist";
        assert driverService.getDrivers().containsKey("2") : "Driver with key '2' should exist";
        assert driverService.getDrivers().containsKey("3") : "Driver with key '3' should exist";

        // Optionally, assert some properties of a driver
        Driver arpit = driverService.getDrivers().get("1");
        assert arpit != null : "Driver 'Arpit' should not be null";
        assert "Arpit".equals(arpit.getName()) : "Driver name should be 'Arpit'";
        assert "1234567890".equals(arpit.getPhone()) : "Driver phone number mismatch";

        System.out.println(DriverServiceTest.class.getName() + ": All tests passed!");
    }
}