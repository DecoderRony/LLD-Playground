package main.Entities;

public class RegisterRequest {
    private final String name;
    private final String phone;
    private final String password;

    public RegisterRequest(String name, String phone, String password) {
        this.name = name;
        this.phone = phone;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getPassword() {
        return password;
    }
}
