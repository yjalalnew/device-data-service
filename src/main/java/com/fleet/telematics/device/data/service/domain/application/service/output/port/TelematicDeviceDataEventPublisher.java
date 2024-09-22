package com.fleet.telematics.device.data.service.domain.application.service.output.port;

import com.fleet.telematics.device.data.service.domain.entity.TelematicsData;
import com.fleet.telematics.device.data.service.domain.event.DomainEventPublisher;

public interface TelematicDeviceDataEventPublisher extends DomainEventPublisher<TelematicsData> {

}
