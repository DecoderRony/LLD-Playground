package main.Interfaces;

import main.Entities.Driver;
import main.Entities.RideMetaData;

public interface IDriverSelectionStrategy {
    Driver matchDriver(RideMetaData rMetadata);
}
