package com.musala.drones.repository;

import com.musala.drones.models.Drone;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DroneRepository extends CrudRepository<Drone, Long> {}
