package com.todos.api.controllers;

import com.todos.api.domain.activity.Activity;
import com.todos.api.domain.event.Event;
import com.todos.api.dtos.ActivityDTO;
import com.todos.api.dtos.EventDTO;
import com.todos.api.serivces.ActivityService;
import com.todos.api.serivces.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/events")
public class EventController {

    @Autowired
    private EventService service;

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Event>> getById(String id){
        var activity = service.getById(id);
        if(activity.isEmpty()){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(activity);
    }

    @PostMapping
    public ResponseEntity create(@RequestBody EventDTO data) throws Exception {
        var createdActivity = service.create(data);
        return ResponseEntity.ok(createdActivity);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteById(String id){
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
