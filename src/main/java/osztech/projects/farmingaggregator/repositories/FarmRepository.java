package osztech.projects.farmingaggregator.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import osztech.projects.farmingaggregator.domain.Farm;

import java.util.UUID;

public interface FarmRepository extends PagingAndSortingRepository<Farm, UUID> {

}
