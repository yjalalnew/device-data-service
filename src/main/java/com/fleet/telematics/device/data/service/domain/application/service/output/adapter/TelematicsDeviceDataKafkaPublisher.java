package com.fleet.telematics.device.data.service.domain.application.service.output.adapter;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.fleet.telematics.device.data.service.domain.application.service.output.port.TelematicDeviceDataEventPublisher;
import com.fleet.telematics.device.data.service.domain.entity.TelematicsData;

@Service
public class TelematicsDeviceDataKafkaPublisher implements TelematicDeviceDataEventPublisher {

	@Value("${spring.kafka.topic.name}")
	private String topicName;

	private final KafkaTemplate<UUID, TelematicsData> kafkaTemplate;

	public TelematicsDeviceDataKafkaPublisher(KafkaTemplate<UUID, TelematicsData> kafkaTemplate) {
		this.kafkaTemplate = kafkaTemplate;
	}

	@Override
	public void publish(TelematicsData telematicsData) {
		kafkaTemplate.send(topicName, telematicsData.getDeviceId(), telematicsData);

	}
}
