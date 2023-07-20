package com.musala.drones.dto.response;

import com.musala.drones.dto.DroneDto;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class DroneResponseDto extends DroneDto implements Serializable {
  Long id;
}
