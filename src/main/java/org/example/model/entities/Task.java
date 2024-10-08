package org.example.model.entities;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "tasks")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    private LocalDateTime createdAt;
    private LocalDateTime deadline;
    private LocalDateTime completedAt;
    private boolean completed;

    @ManyToOne
    @JoinColumn(name = "creator_id")
    private User creator;

    @ManyToOne
    @JoinColumn(name = "assignee_id")
    private User assignee;

    @ElementCollection
    @CollectionTable(name = "task_tags")
    private Set<String> tags;

    public boolean isDeadlineValid() {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime maxFutureDate = now.plusDays(3);
        return !deadline.isBefore(now) && !deadline.isAfter(maxFutureDate);
    }

    public boolean canComplete() {
        return !deadline.isBefore(LocalDateTime.now());
    }
}