package com.musala.drones.models;

import com.musala.drones.models.enums.Model;
import com.musala.drones.models.enums.State;
import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.DecimalMax;
import lombok.Data;

@Data
@Entity
@Table(name = "drones")
public class Drone implements Serializable {
  @Id
  @GeneratedValue
  @Column(name = "id")
  Long id;

  @Column(name = "serial_number", nullable = false, length = 100)
  String serialNumber;

  @Enumerated
  @Column(columnDefinition = "tinyint")
  Model model;

  @Column(name = "weight_limit", nullable = false)
  @DecimalMax(value = "500.0")
  Double weightLimit;

  @Column(name = "battery_capacity", nullable = false)
  Integer batteryCapacity;

  @Enumerated
  @Column(columnDefinition = "tinyint")
  State state;
}
