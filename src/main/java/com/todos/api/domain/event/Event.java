package com.todos.api.domain.event;

import com.todos.api.domain.activity.Activity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity(name = "events")
@Table(name = "events")
@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private Date createdDate;
    @ManyToOne
    @JoinColumn(name="activity_id")
    private Activity activity;
}
