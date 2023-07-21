package com.musala.drones.dto.assembler;

import com.musala.drones.dto.DroneDto;
import com.musala.drones.dto.response.DroneResponseDto;
import com.musala.drones.models.Drone;
import java.util.List;
import java.util.stream.Collectors;

public class DroneDtoAssembler {

  private DroneDtoAssembler() {}

  public static Drone toModel(DroneDto droneDto) {
    return Drone.builder()
        .serialNumber(droneDto.getSerialNumber())
        .model(droneDto.getModel())
        .weightLimit(droneDto.getWeightLimit())
        .batteryCapacity(droneDto.getBatteryCapacity())
        .state(droneDto.getState())
        .build();
  }

  public static DroneResponseDto toDto(Drone drone) {
    DroneResponseDto droneResponseDto = new DroneResponseDto(drone.getId());
    droneResponseDto.setSerialNumber(drone.getSerialNumber());
    droneResponseDto.setState(drone.getState());
    droneResponseDto.setBatteryCapacity(drone.getBatteryCapacity());
    droneResponseDto.setModel(drone.getModel());
    droneResponseDto.setWeightLimit(drone.getWeightLimit());
    return droneResponseDto;
  }

  public static List<DroneResponseDto> toDto(List<Drone> drones) {
    return drones.stream().map(DroneDtoAssembler::toDto).collect(Collectors.toList());
  }
}
