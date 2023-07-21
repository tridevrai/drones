package com.musala.drones.service;

import com.musala.drones.dto.DroneDto;
import com.musala.drones.dto.LoadDto;
import com.musala.drones.models.Drone;
import com.musala.drones.models.Medication;
import java.util.List;

public interface DroneService {
  Drone register(DroneDto droneDto);

  String load(LoadDto loadDto);

  List<Medication> getLoadedMedications(Long droneId, String loadReferenceId);

  List<Drone> getAvailableDrones();

  int checkBatteryPercentage(Long droneId);
}
