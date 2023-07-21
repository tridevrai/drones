package com.musala.drones.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.musala.drones.models.enums.Model;
import com.musala.drones.models.enums.State;
import javax.validation.constraints.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DroneDto {
  String serialNumber;
  Model model;

  @DecimalMin(value = "0.0")
  @DecimalMax(value = "500.0", message = "weight limit cannot exceed 500 grams")
  Double weightLimit;

  int batteryCapacity;
  State state;

  @AssertFalse(message = "serial number cannot exceed 100 characters")
  @JsonIgnore
  public boolean isSerialNumberCharacterExceed100() {
    return serialNumber.length() > 100;
  }
}
