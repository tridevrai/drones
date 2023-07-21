package com.musala.drones.models;

import javax.persistence.*;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "audit_logs")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuditLog extends BaseModel {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  Long id;

  @Column(name = "audit_type")
  String auditType;

  @Column(name = "drone_id")
  Long droneId;

  @Column(name = "battery_capacity")
  Integer batteryCapacity;
}
