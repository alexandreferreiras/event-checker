package com.carecru.eventchecker.usecases;

import com.carecru.eventchecker.domains.Event;
import com.carecru.eventchecker.gateways.stores.EventStore;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CreateOrUpdateEvent {

    private final EventStore eventStore;

    public Event execute(final String name) {
        final Event event = eventStore.findByName(name).orElseGet(() -> new Event(name, 0));
        event.addCount();
        eventStore.save(event);
        return event;
    }
}
