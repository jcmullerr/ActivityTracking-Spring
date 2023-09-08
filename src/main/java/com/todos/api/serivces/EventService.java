package com.todos.api.serivces;

import com.todos.api.domain.event.Event;
import com.todos.api.dtos.EventDTO;
import com.todos.api.repositories.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class EventService {
    private EventRepository repository;
    private ActivityService activityService;

    @Autowired

    public EventService(EventRepository repository, ActivityService activityService){
        this.repository = repository;
        this.activityService = activityService;
    }

    public Event create(EventDTO data) throws Exception {
        var newEvent = new Event();
        var activity = activityService.getById(data.activityId());
        if(activity.isEmpty()){
            throw new Exception("Not Found");
        }
        newEvent.setActivity(activity.get());
        newEvent.setCreatedDate(LocalDate.now());

        return repository.save(newEvent);
    }

    public Optional<Event> getById(String id){
        return repository.findById(id);
    }

    public void deleteById(String id){ repository.deleteById(id); }
}
