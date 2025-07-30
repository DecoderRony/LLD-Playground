package main.Entities;

public class User {
    private String name;
    private Location currLocation;
    private String password;
    private String phone;

    public static User builder() {
        return new User();
    }

    public String getName() {
        return name;
    }

    public User setName(String name) {
        this.name = name;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }

    public Location getCurrLocation() {
        return currLocation;
    }

    public User setCurrLocation(Location currLocation) {
        this.currLocation = currLocation;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public User setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public User build(){
        return this;
    }
}
