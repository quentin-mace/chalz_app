package main;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

class Task implements Serializable {
    String title;
    String description;
    LocalDateTime creation_date;
    Boolean completed;
    LocalDateTime completion_date;
    LocalDate deadline_date;

    Task(String title, String description, LocalDate deadline_date) {
        this.title = title;
        this.description = description;
        this.creation_date = LocalDateTime.now();
        this.completed = false;
        this.completion_date = LocalDateTime.now();
        this.deadline_date = deadline_date;
    }

    public void completeTask() {
        this.completed = true;
        this.completion_date = LocalDateTime.now();
    }
}
