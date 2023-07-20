package com.musala.drones.dto.assembler;

import com.musala.drones.dto.response.DroneResponseDto;
import com.musala.drones.models.Drone;
import java.util.Collections;
import java.util.List;

public class DroneDtoAssembler {

  public static Drone toModel(DroneResponseDto droneDto) {
    return new Drone();
  }

  public static DroneResponseDto toDto(Drone drone) {
    return new DroneResponseDto();
  }

  public static List<DroneResponseDto> toDto(List<Drone> drones) {
    return Collections.emptyList();
  }
}
