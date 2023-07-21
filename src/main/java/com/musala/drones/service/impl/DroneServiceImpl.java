package com.musala.drones.service.impl;

import com.musala.drones.dto.DroneDto;
import com.musala.drones.dto.LoadDto;
import com.musala.drones.dto.assembler.DroneDtoAssembler;
import com.musala.drones.dto.assembler.LoadDtoAssembler;
import com.musala.drones.exceptions.DroneException;
import com.musala.drones.models.Drone;
import com.musala.drones.models.Load;
import com.musala.drones.models.Medication;
import com.musala.drones.models.enums.State;
import com.musala.drones.repository.DroneRepository;
import com.musala.drones.repository.LoadRepository;
import com.musala.drones.repository.MedicationRepository;
import com.musala.drones.service.DroneService;
import com.musala.drones.utils.LoadValidator;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

@Service
public class DroneServiceImpl implements DroneService {
  DroneRepository droneRepository;
  MedicationRepository medicationRepository;
  LoadRepository loadRepository;

  @Autowired
  public void setDroneRepository(DroneRepository droneRepository) {
    this.droneRepository = droneRepository;
  }

  @Autowired
  public void setMedicationRepository(MedicationRepository medicationRepository) {
    this.medicationRepository = medicationRepository;
  }

  @Autowired
  public void setLoadRepository(LoadRepository loadRepository) {
    this.loadRepository = loadRepository;
  }

  @Override
  public Drone register(DroneDto droneDto) {
    Drone droneToRegister = DroneDtoAssembler.toModel(droneDto);
    return droneRepository.save(droneToRegister);
  }

  @Override
  @Transactional
  public String load(LoadDto loadDto) {
    Optional<Drone> optionalDrone = droneRepository.findById(loadDto.getDroneId());
    Drone droneToLoad =
        optionalDrone.orElseThrow(
            () ->
                new DroneException(
                    "Drone is not registered with id = %s. Please register it first.",
                    loadDto.getDroneId()));
    if (LoadValidator.belowAcceptableBatteryPercentage(droneToLoad))
      throw new DroneException(
          "Drone cannot be Loaded due to below %s percentage battery limit",
          LoadValidator.ACCEPTABLE_BATTERY_PERCENTAGE_LIMIT);

    droneToLoad.setState(State.LOADING);
    droneRepository.save(droneToLoad);

    Iterable<Medication> medicationsThatNeedsToBeLoaded =
        medicationRepository.findAllById(loadDto.getMedicationIds());
    if (LoadValidator.weighLimitExceed(medicationsThatNeedsToBeLoaded)) {
      throw new DroneException(
          "Drone = %s cannot be loaded since total weight to load is above %s grams.",
          LoadValidator.WEIGHT_LIMIT, loadDto.getDroneId());
    }

    String loadReferenceId = UUID.randomUUID().toString();
    List<Load> listOfLoadModels =
        LoadDtoAssembler.toModel(droneToLoad, medicationsThatNeedsToBeLoaded, loadReferenceId);
    loadRepository.saveAll(listOfLoadModels);

    droneToLoad.setState(State.LOADED);
    droneRepository.save(droneToLoad);

    return loadReferenceId;
  }

  @Override
  public List<Medication> getLoadedMedications(Long droneId, String loadReferenceId) {
    List<Load> allLoadedRecords = loadRepository.getAllLoadedRecords(droneId, loadReferenceId);
    if (CollectionUtils.isEmpty(allLoadedRecords))
      throw new DroneException(
          "There is no Drone of id = %s that has loaded with reference id =%s",
          droneId, loadReferenceId);
    return allLoadedRecords.stream().map(Load::getMedication).collect(Collectors.toList());
  }

  @Override
  public List<Drone> getAvailableDrones() {
    return droneRepository.findAllByStateIsAndBatteryCapacityIsGreaterThan(
        State.IDLE, LoadValidator.ACCEPTABLE_BATTERY_PERCENTAGE_LIMIT);
  }

  @Override
  public int checkBatteryPercentage(Long droneId) {
    Drone drone =
        droneRepository
            .findById(droneId)
            .orElseThrow(
                () ->
                    new DroneException(
                        "Drone is not registered with id = %s. Please register it first.",
                        droneId));
    return drone.getBatteryCapacity();
  }
}
