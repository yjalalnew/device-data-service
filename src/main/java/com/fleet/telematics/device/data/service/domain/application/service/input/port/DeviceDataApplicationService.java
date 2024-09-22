package com.fleet.telematics.device.data.service.domain.application.service.input.port;

import com.fleet.telematics.device.data.service.domain.application.service.dto.PublishTelematicsCommand;


public interface DeviceDataApplicationService {

	public void enqueueTelematicsData(PublishTelematicsCommand telematicsDataDTO);
}
