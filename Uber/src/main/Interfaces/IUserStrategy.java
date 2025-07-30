package main.Interfaces;

import main.Entities.RegisterRequest;
import main.Entities.User;

public interface IUserStrategy<T extends User> {
    T registerUser(RegisterRequest userDetails);
    T getUser(String phone);
}
