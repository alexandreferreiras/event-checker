package com.carecru.eventchecker.gateways.http.controllers;

import com.carecru.eventchecker.domains.Event;
import com.carecru.eventchecker.gateways.http.json.EventInputJson;
import com.carecru.eventchecker.gateways.http.json.EventJson;
import com.carecru.eventchecker.usecases.CreateOrUpdateEvent;
import com.carecru.eventchecker.usecases.FindAllEvents;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RequiredArgsConstructor
@RestController
public class EventsController {

    private final CreateOrUpdateEvent createOrUpdateEvent;

    private final FindAllEvents findAllEvents;

    @PostMapping(produces = APPLICATION_JSON_VALUE, consumes = APPLICATION_JSON_VALUE, value = "/events")
    public ResponseEntity<EventJson> postEvent(@RequestBody final EventInputJson eventInputJson) {
        final Event event = createOrUpdateEvent.execute(eventInputJson.getName());
        return ResponseEntity.ok(new EventJson(event.getName(), event.getCount()));
    }

    @GetMapping(produces = APPLICATION_JSON_VALUE, value = "/stats")
    public ResponseEntity<List<EventJson>> findAll() {
        return ResponseEntity.ok(findAllEvents.execute()
                .stream()
                .map(event -> new EventJson(event.getName(), event.getCount()))
                .collect(Collectors.toList()));
    }

}
