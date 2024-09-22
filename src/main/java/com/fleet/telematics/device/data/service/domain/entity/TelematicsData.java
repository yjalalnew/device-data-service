package com.fleet.telematics.device.data.service.domain.entity;

import java.time.ZonedDateTime;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
@AllArgsConstructor
public class TelematicsData {
	private final UUID deviceId;
	private final double latitude;
	private final double longitude;
	private final double fuelPercentage;
	private final double speed;
	private final ZonedDateTime timestamp;
}
