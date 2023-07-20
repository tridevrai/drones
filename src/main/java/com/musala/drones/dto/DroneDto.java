package com.musala.drones.dto;

import com.musala.drones.models.enums.Model;
import com.musala.drones.models.enums.State;
import java.io.Serializable;
import lombok.Data;

@Data
public class DroneDto implements Serializable {
  String serialNumber;
  Model model;
  double weightLimit;
  int batteryCapacity;
  State state;
}
