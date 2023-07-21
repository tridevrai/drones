package com.musala.drones.exceptions;

public class DroneException extends RuntimeException {
  public DroneException(String messageFormat, Object... args) {
    super(String.format(messageFormat, args));
  }
}
