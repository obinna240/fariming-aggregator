package osztech.projects.farmingaggregator.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public final class Farms {

    private UUID id;
    private String farmName;
    private String location;
    private LocalDate dateStarted;
    private OffsetDateTime lastModifiedDate;
    private OffsetDateTime dateRegistered;
    private double latitude;
    private double longitude;
    private List<String> produce;

}
