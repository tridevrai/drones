package com.musala.drones.dto;

import java.io.Serializable;
import java.util.List;
import lombok.Data;

@Data
public class LoadDto implements Serializable {
  private Long droneId;
  private List<String> medicationCodes;
}
