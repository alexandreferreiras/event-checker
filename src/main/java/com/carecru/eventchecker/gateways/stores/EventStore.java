package com.carecru.eventchecker.gateways.stores;

import com.carecru.eventchecker.domains.Event;

import java.util.List;
import java.util.Optional;

public interface EventStore {

    void save(final Event event);

    Optional<Event> findByName(final String name);

    List<Event> findAll();
}
