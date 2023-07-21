package com.musala.drones.dto.response;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MedicationResponseDto implements Serializable {
  Long id;
  String name;
  Double weight;
  String code;
  byte[] image;
}
