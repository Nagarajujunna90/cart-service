package com.example.cartservice.service;


import com.example.cartservice.model.EventStore;
import com.example.cartservice.repo.EventRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class EventServiceLogImpl implements EventServiceLog {

    @Autowired
    private EventRepository repo;


    @Override
    public void addEvent(Object event,String eventType)  {

        EventStore eventStore = new EventStore();

        try {
            eventStore.setEventData(new ObjectMapper().writeValueAsString(event));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        eventStore.setEventType(eventType);

        eventStore.setEntityId(null);

        eventStore.setEventTime(LocalDateTime.now());

        repo.save(eventStore);
    }

    @Override
    public Iterable<EventStore> fetchAllEvents(String name) {

        return repo.findByEntityId(name);

    }

    @Override
    public Iterable<EventStore> fetchAllEventsTillDate(String name, LocalDateTime date) {

        return repo.findByEntityIdAndEventTimeLessThanEqual(name, date);

    }
}