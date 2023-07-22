package com.example.cartservice.repo;

import com.example.cartservice.model.EventStore;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public interface EventRepository extends CrudRepository<EventStore, Long>{


    Iterable<EventStore> findByEntityId(String entityId);

    Iterable<EventStore> findByEntityIdAndEventTimeLessThanEqual(String entityId,LocalDateTime date);
}