package com.musala.drones.dto.response;

import java.io.Serializable;
import lombok.Data;

@Data
public class MedicationResponseDto implements Serializable {
  Long id;
  String name;
  Double weight;
  String code;
  byte[] image;
}
