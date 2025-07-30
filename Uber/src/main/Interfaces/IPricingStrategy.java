package main.Interfaces;

import main.Entities.RideMetaData;

public interface IPricingStrategy {
    float calculatePrice(RideMetaData meta);
}
