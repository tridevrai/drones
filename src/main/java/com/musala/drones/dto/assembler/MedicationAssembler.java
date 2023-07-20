package com.musala.drones.dto.assembler;

import com.musala.drones.dto.response.MedicationResponseDto;
import com.musala.drones.models.Medication;
import java.util.Collections;
import java.util.List;

public class MedicationAssembler {
  public static MedicationResponseDto toDto(Medication medication) {
    return new MedicationResponseDto();
  }

  public static List<MedicationResponseDto> toDto(List<Medication> medications) {
    return Collections.emptyList();
  }
}
