package main.Entities;

public class Location {
    private int x;
    private int y;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public float getDistance(Location loc){
        // some distance calculation logic
        return 0.00f;
    }

    public Location(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
