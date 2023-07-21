package com.musala.drones.dto.assembler;

import com.musala.drones.models.Drone;
import com.musala.drones.models.Load;
import com.musala.drones.models.Medication;
import java.util.ArrayList;
import java.util.List;

public class LoadDtoAssembler {

  public static List<Load> toModel(
      Drone drone, Iterable<Medication> medications, String loadReferenceId) {
    List<Load> loadModels = new ArrayList<>();
    medications.forEach(
        medication ->
            loadModels.add(
                Load.builder()
                    .drone(drone)
                    .loadReferenceId(loadReferenceId)
                    .medication(medication)
                    .build()));
    return loadModels;
  }
}
