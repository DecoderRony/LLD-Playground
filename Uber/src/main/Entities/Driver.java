package main.Entities;

public class Driver extends User {
    private Vehicle vehicleDetails;
    private int rating;
    private boolean isAvailable;

    public Driver(String name, String phoneNumber, String password, Location location, Vehicle vehicleDetails, int rating, Boolean isAvailable) {
        builder().setName(name).setPhone(phoneNumber).setPassword(password).setCurrLocation(location).build();
        this.vehicleDetails = vehicleDetails;
        this.rating = rating;
        this.isAvailable = isAvailable;
    }

    public Vehicle getVehicleDetails() {
        return vehicleDetails;
    }

    public void setVehicleDetails(Vehicle vehicleDetails) {
        this.vehicleDetails = vehicleDetails;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }
}
