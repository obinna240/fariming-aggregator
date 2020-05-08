package osztech.projects.farmingaggregator.services;

import osztech.projects.farmingaggregator.model.Farms;

import java.util.UUID;

public interface FarmsService {
    Farms getFarmsById(UUID farmId);
    Farms saveFarm(Farms farms);
    void updateFarm(Farms farm, UUID farmiId);
    void deleteFarmById(UUID farmId);
}
