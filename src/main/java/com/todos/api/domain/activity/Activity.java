package com.todos.api.domain.activity;

import jakarta.persistence.*;
import lombok.*;

@Entity(name = "activities")
@Table(name = "activities")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Activity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String description;
}
