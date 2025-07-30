package main.Managers;

import main.Entities.RegisterRequest;
import main.Entities.User;
import main.Interfaces.IUserStrategy;

public class RegistrationManager<T extends User> {
    private final IUserStrategy<T> registrationStrategy;
    private static volatile RegistrationManager<? extends User> instance;

    private RegistrationManager(IUserStrategy<T> strategy) {
        this.registrationStrategy = strategy;
    } // private constructor to follow singleton pattern

    public static <T extends User> RegistrationManager<? extends User> getInstance(IUserStrategy<T> strategy){
        if(instance == null){
            // adding lock
            synchronized (RegistrationManager.class){
                if(instance == null){
                    System.out.println("Creating single instance of RegistrationManager");
                    instance = new RegistrationManager<>(strategy);
                }
            }
        }
        return instance;
    }

    public T registerUser(RegisterRequest userDetails) {
        return this.registrationStrategy.registerUser(userDetails);
    }
}
