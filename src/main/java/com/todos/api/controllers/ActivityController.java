package com.todos.api.controllers;

import com.todos.api.domain.activity.Activity;
import com.todos.api.dtos.ActivityDTO;
import com.todos.api.serivces.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/activities")
public class ActivityController {

    @Autowired
    private ActivityService activityService;

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Activity>> getById(String id){
        var activity = activityService.getById(id);
        if(activity.isEmpty()){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(activity);
    }

    @PostMapping
    public ResponseEntity create(@RequestBody ActivityDTO data){
        var createdActivity = activityService.create(data);
        return ResponseEntity.ok(createdActivity);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteById(String id){
        activityService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity update(String id, @RequestBody ActivityDTO data) throws Exception {
        var updatedEntity = activityService.update(id, data);
        return ResponseEntity.ok(updatedEntity);
    }
}
