package osztech.projects.farmingaggregator.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Farm {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name= "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(length = 36, columnDefinition = "varchar(36)", updatable = false, nullable = false)
    @JsonProperty("farmId")
    private String id;

    @Version
    private Long version;

    @CreationTimestamp
    @Column(updatable = false)
    private Timestamp createdDate;

    @Column(unique = true)
    private Long uniqueFarmId;

    private String farmName;
    private String location;

    @JsonFormat(pattern="yyyy-MM-dd", shape = JsonFormat.Shape.STRING)
    private LocalDate dateStarted;

    @CreationTimestamp
    @Column(updatable = false)
    private Timestamp lastModifiedDate;

    private Timestamp dateRegistered;
    private double latitude;
    private double longitude;

}
