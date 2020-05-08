package osztech.projects.farmingaggregator.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import osztech.projects.farmingaggregator.domain.Farm;
import osztech.projects.farmingaggregator.repositories.FarmRepository;

import java.util.UUID;

@Component
public class FarmRunner implements CommandLineRunner {

    private final FarmRepository farmRepository;

    public FarmRunner(FarmRepository farmRepository) {
        this.farmRepository = farmRepository;
    }

    private void loadObjects(){
        if(farmRepository.count() == 0) {
            farmRepository.save(Farm.builder().id(UUID.randomUUID().toString())
            .farmName("Test farm 1")
            .location("London")
            .uniqueFarmId(11111L)
            .version(1L).build());
        }
    }

    @Override
    public void run(String... args) throws Exception {
        loadObjects();
    }



}
