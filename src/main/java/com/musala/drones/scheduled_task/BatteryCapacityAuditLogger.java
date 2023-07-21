package com.musala.drones.scheduled_task;

import com.musala.drones.models.AuditLog;
import com.musala.drones.models.Drone;
import com.musala.drones.repository.AuditLogRepository;
import com.musala.drones.repository.DroneRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BatteryCapacityAuditLogger implements Runnable {

  DroneRepository droneRepository;
  AuditLogRepository auditLogRepository;

  @Autowired
  public void setDroneRepository(DroneRepository droneRepository) {
    this.droneRepository = droneRepository;
  }

  @Autowired
  public void setAuditLogRepository(AuditLogRepository auditLogRepository) {
    this.auditLogRepository = auditLogRepository;
  }

  @Override
  public void run() {
    List<AuditLog> auditLogList = new ArrayList<>();

    Iterable<Drone> allAvailableDrones = droneRepository.findAll();
    allAvailableDrones.forEach(
        drone -> {
          int batteryCapacity = drone.getBatteryCapacity();
          auditLogList.add(
              AuditLog.builder()
                  .auditType("Battery capacity Audit History")
                  .droneId(drone.getId())
                  .batteryCapacity(batteryCapacity)
                  .build());
        });

    auditLogRepository.saveAll(auditLogList);
  }
}
