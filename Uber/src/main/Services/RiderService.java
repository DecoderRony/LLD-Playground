package main.Services;

import main.Entities.Rider;

import java.util.concurrent.ConcurrentHashMap;

public class RiderService {
    private final ConcurrentHashMap<String, Rider> riders = new ConcurrentHashMap<>();
    private static volatile RiderService instance;

    private RiderService(){} //private constructor to follow singleton pattern

    public static RiderService getInstance(){
        if(instance == null){
            // creating a lock to ensure only one instance is created
            synchronized (RiderService.class){
                if(instance == null){
                    System.out.println("Creating single instance of RiderService");
                    instance = new RiderService();
                }
            }
        }

        return instance;
    }

    public ConcurrentHashMap<String, Rider> getRiders() {
        return riders;
    }

    public void addRider(String key, Rider riderDetails) {
        this.riders.put(key, riderDetails);
    }
}
