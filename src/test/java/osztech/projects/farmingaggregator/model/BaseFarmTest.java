package osztech.projects.farmingaggregator.model;

import osztech.projects.farmingaggregator.domain.Farm;

import java.time.LocalDate;

public class BaseFarmTest {

    public Farm farm = Farm.builder().farmName("farmTest")
            .id("1")
            .location("Germany")
            .latitude(1L)
            .longitude(2L)
            .dateStarted(LocalDate.now())
            .build();
}
