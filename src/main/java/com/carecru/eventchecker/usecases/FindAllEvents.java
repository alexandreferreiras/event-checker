package com.carecru.eventchecker.usecases;

import com.carecru.eventchecker.domains.Event;
import com.carecru.eventchecker.gateways.stores.EventStore;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FindAllEvents {

    private final EventStore eventStore;

    public List<Event> execute() {
        return eventStore.findAll();
    }
}
