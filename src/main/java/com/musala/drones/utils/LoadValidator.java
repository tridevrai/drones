package com.musala.drones.utils;

import com.musala.drones.models.Drone;
import com.musala.drones.models.Medication;
import java.util.concurrent.atomic.AtomicReference;

public class LoadValidator {

  private LoadValidator() {}

  public static final double WEIGHT_LIMIT = 500;
  public static final int ACCEPTABLE_BATTERY_PERCENTAGE_LIMIT = 25;

  public static boolean weighLimitExceed(Iterable<Medication> medications) {
    AtomicReference<Double> weight = new AtomicReference<>(0.0);
    medications.forEach(medication -> weight.set(weight.get() + medication.getWeight()));
    return weight.get() > WEIGHT_LIMIT;
  }

  public static boolean belowAcceptableBatteryPercentage(Drone drone) {
    return drone.getBatteryCapacity() < ACCEPTABLE_BATTERY_PERCENTAGE_LIMIT;
  }
}
