package com.todos.api.serivces;

import com.todos.api.dtos.ActivityDTO;
import com.todos.api.repositories.ActivityRepository;
import jakarta.validation.constraints.AssertTrue;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ActivityServiceTest {
    @Mock
    private ActivityRepository repository;
    @InjectMocks
    private ActivityService sut;

    @BeforeAll
    void setupBeforeAll(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void shouldCreateSuccessfully() {
        var data = new ActivityDTO("Test Activity");
        var createdActivity = sut.create(data);
        verify(repository, atLeastOnce()).save(any());
    }

    @Test
    void getById() {
    }

    @Test
    void deleteById() {
    }

    @Test
    void update() {
    }
}