package com.todos.api.serivces;

import com.todos.api.dtos.ActivityDTO;
import com.todos.api.domain.activity.Activity;
import com.todos.api.repositories.ActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ActivityService {
    @Autowired
    private ActivityRepository activityRepository;

    public Activity create(ActivityDTO data){
        var newActivity = new Activity();
        newActivity.setDescription(data.description());
        return activityRepository.save(newActivity);
    }

    public Optional<Activity> getById(String id){
        return activityRepository.findActivityById(id);
    }

    public void deleteById(String id){ activityRepository.deleteById(id); }

    public Activity update(String id, ActivityDTO data) throws Exception {
        var entity = activityRepository.findById(id);
        if(entity.isEmpty()){
            throw new Exception("Not found");
        }

        var entityToBeUpdated = entity.get();
        entityToBeUpdated.setDescription(data.description());

        return activityRepository.save(entityToBeUpdated);
    }
}
