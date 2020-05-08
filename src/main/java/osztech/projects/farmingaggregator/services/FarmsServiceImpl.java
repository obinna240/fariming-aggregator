package osztech.projects.farmingaggregator.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import osztech.projects.farmingaggregator.model.Farms;
import java.util.UUID;

@Slf4j
@Service
public class FarmsServiceImpl implements FarmsService {

    @Override
    public Farms getFarmsById(UUID farmId) {
        return Farms.builder().farmName("Test Farm")
                .id(UUID.randomUUID())
                .location("Lagos")
                .latitude(1.0)
                .longitude(1.0)
                .build();
    }

    @Override
    public Farms saveFarm(Farms farms) {
        return Farms.builder().farmName("Test Farm")
                .id(UUID.randomUUID())
                .location("Lagos")
                .latitude(1.0)
                .longitude(1.0)
                .build();
    }

    @Override
    public void updateFarm(Farms farm, UUID farmiId) {
        log.debug("updating farm");
    }

    @Override
    public void deleteFarmById(UUID farmId) {
        log.debug("deleting farm by id");
    }
}
