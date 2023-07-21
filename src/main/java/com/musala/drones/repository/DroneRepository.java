package com.musala.drones.repository;

import com.musala.drones.models.Drone;
import com.musala.drones.models.enums.State;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DroneRepository extends CrudRepository<Drone, Long> {
  List<Drone> findAllByStateIsAndBatteryCapacityIsGreaterThan(State state, int batteryCapacity);
}
