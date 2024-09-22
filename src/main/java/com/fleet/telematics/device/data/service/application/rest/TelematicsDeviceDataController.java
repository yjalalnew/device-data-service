package com.fleet.telematics.device.data.service.application.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fleet.telematics.device.data.service.domain.application.service.dto.PublishTelematicsCommand;
import com.fleet.telematics.device.data.service.domain.application.service.input.port.DeviceDataApplicationService;
import com.fleet.telematics.device.data.service.domain.application.service.output.adapter.TelematicsDeviceDataKafkaPublisher;
import com.fleet.telematics.device.data.service.domain.entity.TelematicsData;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/api/telematics")
public class TelematicsDeviceDataController {

	private DeviceDataApplicationService deviceDataApplicationService;

	public TelematicsDeviceDataController(DeviceDataApplicationService deviceDataApplicationService) {
		this.deviceDataApplicationService = deviceDataApplicationService;
	}

	@PostMapping("/data")
	public ResponseEntity<String> receiveTelematicsData(
			@RequestBody PublishTelematicsCommand publishTelematicsCommand) {
		log.info("Received telematics data from " + publishTelematicsCommand.getDeviceId());
		
		deviceDataApplicationService.enqueueTelematicsData(publishTelematicsCommand);
		
		log.info("Published telematics data " + publishTelematicsCommand.getDeviceId());
		return ResponseEntity.ok("Telematics data received successfully");
	}
}
