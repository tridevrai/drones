package com.musala.drones.service;

import com.musala.drones.dto.LoadDto;
import com.musala.drones.dto.response.DroneResponseDto;
import com.musala.drones.models.Drone;
import com.musala.drones.models.Medication;
import java.util.List;

public interface DroneService {
  Drone register(DroneResponseDto droneDto);

  String load(LoadDto loadDto);
  // This will give the latest loaded medicines for the given drone Id
  List<Medication> getLoadedMedications(Long droneId);
  // This will give the particular loaded medicines for the load reference Id
  List<Medication> getLoadedMedications(String loadReferenceId);

  List<Drone> getAvailableDrones();

  int checkBatteryPercentage(Long droneId);
}