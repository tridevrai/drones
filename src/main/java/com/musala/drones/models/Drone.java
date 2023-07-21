package com.musala.drones.models;

import com.musala.drones.models.enums.Model;
import com.musala.drones.models.enums.State;
import java.io.Serializable;
import javax.persistence.*;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "drones")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Drone extends BaseModel implements Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  Long id;

  @Column(name = "serial_number", nullable = false)
  String serialNumber;

  @Enumerated
  @Column(columnDefinition = "tinyint")
  Model model;

  @Column(name = "weight_limit", nullable = false)
  Double weightLimit;

  @Column(name = "battery_capacity", nullable = false)
  Integer batteryCapacity;

  @Enumerated
  @Column(columnDefinition = "tinyint")
  State state;
}
