package com.todos.api.repositories;

import com.todos.api.domain.event.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event,String> {
}
