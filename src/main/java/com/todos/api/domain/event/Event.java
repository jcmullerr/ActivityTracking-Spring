package com.todos.api.domain.event;

import com.todos.api.domain.activity.Activity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Date;

@Entity(name = "events")
@Table(name = "events")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private LocalDate createdDate;
    @ManyToOne
    @JoinColumn(name="activity_id")
    private Activity activity;
}
