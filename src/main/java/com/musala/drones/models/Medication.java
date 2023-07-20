package com.musala.drones.models;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import lombok.Data;

@Data
@Entity
@Table(name = "medications")
public class Medication extends BaseModel implements Serializable {
  @Id @GeneratedValue Long id;

  @Pattern(
      regexp = "[a-zA-Z0-9-_]+",
      message = "Name can only contain letters, numbers, '-' and '_'")
  String name;

  Double weight;

  @Pattern(
      regexp = "[A-Z0-9_]+",
      message = "Code can only contain upper case letters, numbers, and '_'")
  String code;

  @NotNull(message = "Image cannot be null")
  byte[] image;
}
