package com.xl1.ddd.domain.event.publisher;

import com.xl1.ddd.domain.event.DomainEvent;

public interface DomainEventPublisher<T extends DomainEvent> {

    void publish(T domainEvent);
}
