package com.musala.drones.models;

import com.musala.drones.models.enums.LoadStatus;
import javax.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "load")
public class Load {
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
