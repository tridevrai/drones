package com.musala.drones.models;

import java.io.Serializable;
import javax.persistence.*;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "load")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Load extends BaseModel implements Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  Long id;

  @OneToOne(cascade = CascadeType.ALL)
  Drone drone;

  @ManyToOne(cascade = CascadeType.ALL)
  Medication medication;

  @Column(name = "load_reference_id")
  String loadReferenceId;
}
