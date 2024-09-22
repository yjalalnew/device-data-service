package com.fleet.telematics.device.data.service.domain.application.service.dto;

import java.time.ZonedDateTime;
import java.util.UUID;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PublishTelematicsCommand {
	@NotNull
	private UUID deviceId;
	@NotNull
	private double latitude;
	@NotNull
	private double longitude;
	@NotNull
	private double fuelPercentage;
	@NotNull
	private double speed;
	@NotNull
	private ZonedDateTime timestamp;

}
