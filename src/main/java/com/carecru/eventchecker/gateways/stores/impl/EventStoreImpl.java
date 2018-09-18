package com.carecru.eventchecker.gateways.stores.impl;

import com.carecru.eventchecker.domains.Event;
import com.carecru.eventchecker.gateways.stores.EventStore;
import com.google.common.collect.ImmutableList;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class EventStoreImpl implements EventStore {

    private static final Map<String, Event> store = new ConcurrentHashMap<>();

    @Override
    public void save(final Event event) {
        store.put(event.getName(), event);
    }

    @Override
    public Optional<Event> findByName(final String name) {
        return Optional.ofNullable(store.get(name));
    }

    @Override
    public List<Event> findAll() {
        return ImmutableList.copyOf(store.values());
    }
}
