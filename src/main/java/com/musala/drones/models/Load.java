package com.musala.drones.models;

import com.musala.drones.models.enums.LoadStatus;
import java.io.Serializable;
import javax.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "load")
public class Load extends BaseModel implements Serializable {
  @Id
  @GeneratedValue
  @Column(name = "id")
  Long id;

  @OneToOne(cascade = CascadeType.ALL)
  Drone drone;

  @ManyToOne(cascade = CascadeType.ALL)
  Medication medication;

  @Column(name = "load_reference_id")
  String loadReferenceId;

  @Enumerated
  @Column(name = "status")
  LoadStatus status;
}
