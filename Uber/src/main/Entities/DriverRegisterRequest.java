package main.Entities;

public class DriverRegisterRequest extends RegisterRequest{
    private Vehicle vehicleDetails;

    public DriverRegisterRequest(String name, String phone, String password, Vehicle vehicleDetails) {
        super(name, phone, password);
        this.vehicleDetails = vehicleDetails;
    }

    public Vehicle getVehicleDetails() {
        return vehicleDetails;
    }
}
