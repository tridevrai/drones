package com.musala.drones.config;

import com.musala.drones.scheduled_task.BatteryCapacityAuditLogger;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SchedulingConfig {
  @Bean
  public ScheduledExecutorService scheduledExecutorService() {
    return Executors.newSingleThreadScheduledExecutor();
  }

  @Bean
  public Runnable batteryLevelChecker() {
    return new BatteryCapacityAuditLogger();
  }

  @Bean
  public ScheduledFuture<?> batteryLevelCheckerTask() {
    // schedules the battery checker logger to run every 1 minutes without initial delay of 1
    // minutes
    return scheduledExecutorService()
        .scheduleAtFixedRate(batteryLevelChecker(), 1, 1, TimeUnit.MINUTES);
  }
}
