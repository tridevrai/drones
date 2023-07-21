package com.musala.drones.controller;

import com.musala.drones.dto.LoadDto;
import com.musala.drones.dto.assembler.DroneDtoAssembler;
import com.musala.drones.dto.assembler.MedicationAssembler;
import com.musala.drones.dto.response.DroneResponseDto;
import com.musala.drones.dto.response.MedicationResponseDto;
import com.musala.drones.service.DroneService;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/drones")
public class DispatchController {

  private DroneService droneService;

  @Autowired
  public void setDroneService(DroneService droneService) {
    this.droneService = droneService;
  }

  @PostMapping
  public ResponseEntity<DroneResponseDto> registerDrone(
      @Valid @RequestBody DroneResponseDto droneDto) {
    return new ResponseEntity<>(
        DroneDtoAssembler.toDto(droneService.register(droneDto)), HttpStatus.CREATED);
  }

  @PostMapping("/loads")
  public ResponseEntity<String> loadMedications(@RequestBody LoadDto loadDto) {
    return new ResponseEntity<>(droneService.load(loadDto), HttpStatus.OK);
  }

  @GetMapping("/{droneId}/loads/{loadReferenceId}/medications")
  public ResponseEntity<List<MedicationResponseDto>> getLoadedMedications(
      @PathVariable Long droneId, @PathVariable String loadReferenceId) {
    return new ResponseEntity<>(
        MedicationAssembler.toDto(droneService.getLoadedMedications(droneId, loadReferenceId)),
        HttpStatus.OK);
  }

  @GetMapping("/available")
  public ResponseEntity<List<DroneResponseDto>> getAvailableDrones() {
    return new ResponseEntity<>(
        DroneDtoAssembler.toDto(droneService.getAvailableDrones()), HttpStatus.OK);
  }

  @GetMapping("/{droneId}/battery-percentage")
  public ResponseEntity<Integer> getBatteryPercentage(@PathVariable long droneId) {
    return new ResponseEntity<>(droneService.checkBatteryPercentage(droneId), HttpStatus.OK);
  }
}
