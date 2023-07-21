package com.musala.drones.dto.response;

import com.musala.drones.dto.DroneDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DroneResponseDto extends DroneDto {
  Long id;
}
