package com.musala.drones.repository;

import com.musala.drones.models.Load;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface LoadRepository extends CrudRepository<Load, Long> {
  @Query(
      value =
          "SELECT u from Load u where u.drone.id=:droneId AND u.loadReferenceId=:loadReferenceId")
  List<Load> getAllLoadedRecords(
      @Param("droneId") Long droneId, @Param("loadReferenceId") String loadReferenceId);
}
