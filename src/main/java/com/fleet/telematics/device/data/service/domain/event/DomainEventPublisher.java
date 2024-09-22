package com.fleet.telematics.device.data.service.domain.event;

public interface DomainEventPublisher<T> extends DomainEvent<T> {

    void publish(T domainEvent);
}
