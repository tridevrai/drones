package com.musala.drones.dto.assembler;

import com.musala.drones.dto.response.MedicationResponseDto;
import com.musala.drones.models.Medication;
import java.util.ArrayList;
import java.util.List;

public class MedicationAssembler {

  private MedicationAssembler() {}

  public static MedicationResponseDto toDto(Medication medication) {
    return MedicationResponseDto.builder()
        .id(medication.getId())
        .name(medication.getName())
        .code(medication.getCode())
        .weight(medication.getWeight())
        .image(medication.getImage())
        .build();
  }

  public static List<MedicationResponseDto> toDto(List<Medication> medications) {
    List<MedicationResponseDto> responseDtos = new ArrayList<>();
    medications.forEach(medication -> responseDtos.add(toDto(medication)));
    return responseDtos;
  }
}
