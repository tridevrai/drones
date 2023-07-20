package com.musala.drones.models;

import com.musala.drones.models.enums.Model;
import com.musala.drones.models.enums.State;
import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.Max;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "drones")
public class Drone extends BaseModel implements Serializable {
  @Id
  @GeneratedValue
  @Column(name = "id")
  Long id;

  @Column(name = "serial_number", nullable = false)
  @Max(value = 100, message = "serial number cannot exceed 100 characters")
  String serialNumber;

  @Enumerated
  @Column(columnDefinition = "tinyint")
  Model model;

  @Column(name = "weight_limit", nullable = false)
  @DecimalMax(value = "500.0", message = "weight limit cannot exceed 500 grams")
  Double weightLimit;

  @Column(name = "battery_capacity", nullable = false)
  Integer batteryCapacity;

  @Enumerated
  @Column(columnDefinition = "tinyint")
  State state;
}
