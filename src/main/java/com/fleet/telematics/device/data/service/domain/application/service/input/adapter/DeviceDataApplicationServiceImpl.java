package com.fleet.telematics.device.data.service.domain.application.service.input.adapter;

import org.springframework.stereotype.Component;

import com.fleet.telematics.device.data.service.domain.application.service.dto.PublishTelematicsCommand;
import com.fleet.telematics.device.data.service.domain.application.service.input.port.DeviceDataApplicationService;
import com.fleet.telematics.device.data.service.domain.application.service.output.port.TelematicDeviceDataEventPublisher;
import com.fleet.telematics.device.data.service.domain.entity.TelematicsData;

@Component
public class DeviceDataApplicationServiceImpl implements DeviceDataApplicationService {

	private TelematicDeviceDataEventPublisher telematicDeviceDataEventPublisher;

	public DeviceDataApplicationServiceImpl(TelematicDeviceDataEventPublisher telematicDeviceDataEventPublisher) {
		this.telematicDeviceDataEventPublisher = telematicDeviceDataEventPublisher;
	}

	@Override
	public void enqueueTelematicsData(PublishTelematicsCommand publishTelematicsCommand) {
		TelematicsData telematicsData = TelematicsData.builder().deviceId(publishTelematicsCommand.getDeviceId())
				.latitude(publishTelematicsCommand.getLatitude()).longitude(publishTelematicsCommand.getLongitude())
				.fuelPercentage(publishTelematicsCommand.getFuelPercentage()).speed(publishTelematicsCommand.getSpeed())
				.build();
		telematicDeviceDataEventPublisher.publish(telematicsData);
	}

}
