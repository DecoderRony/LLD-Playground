package main.Strategies.Registration;

import main.Entities.RegisterRequest;
import main.Entities.Rider;
import main.Interfaces.IUserStrategy;
import main.Services.RiderService;

public class RiderRegistrationStrategy implements IUserStrategy<Rider> {
    private final RiderService riderService;

    public RiderRegistrationStrategy(RiderService service){
        this.riderService = service;
    }

    @Override
    public Rider registerUser(RegisterRequest userDetails) {
        if(this.riderService.getRiders().containsKey(userDetails.getPhone())){
            throw new IllegalArgumentException("Rider already registered");
        }


        Rider rider = (Rider)Rider.builder().setName(userDetails.getName()).setPassword(userDetails.getPassword()).setPhone(userDetails.getPhone()).build();
        this.riderService.addRider(userDetails.getPhone(), rider);
        return rider;
    }

    @Override
    public Rider getUser(String phone) {
        var riders = this.riderService.getRiders();

        if(!riders.containsKey(phone)){
            throw new IllegalArgumentException("Rider not registered");
        }

        return riders.get(phone);
    }
}
