package com.musala.drones.repository;

import com.musala.drones.models.Load;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoadRepository extends CrudRepository<Load, Long> {}
