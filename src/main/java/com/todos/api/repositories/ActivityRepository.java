package com.todos.api.repositories;

import com.todos.api.domain.activity.Activity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ActivityRepository extends JpaRepository<Activity, String> {
    Optional<Activity> findActivityById(String id);
}
