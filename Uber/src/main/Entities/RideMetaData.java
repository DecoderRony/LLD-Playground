package main.Entities;

public class RideMetaData {
    private Location startLocation;
    private Location endLocation;

    public static RideMetaData builder(){
        return new RideMetaData();
    }

    public Location getStartLocation() {
        return startLocation;
    }

    public RideMetaData setStartLocation(Location startLocation) {
        this.startLocation = startLocation;
        return this;
    }

    public Location getEndLocation() {
        return endLocation;
    }

    public RideMetaData setEndLocation(Location endLocation) {
        this.endLocation = endLocation;
        return this;
    }

    public RideMetaData build(){
        return this;
    }
}
