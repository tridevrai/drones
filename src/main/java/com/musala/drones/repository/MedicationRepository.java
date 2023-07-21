package com.musala.drones.repository;

import com.musala.drones.models.Medication;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicationRepository extends CrudRepository<Medication, Long> {}
