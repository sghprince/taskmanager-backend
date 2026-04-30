

package com.taskmanager.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @ManyToOne
    private Project project;

    @ManyToOne
    private User assignedTo;

    private String status; // TODO / IN_PROGRESS / DONE

    private LocalDate dueDate;
}
