package org.example.service;

import org.example.model.entities.Task;
import org.example.repository.interfaces.TaskRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Optional<Task> findById(Long id) {
        return taskRepository.findById(id);
    }

    public List<Task> findAll() {
        return taskRepository.findAll();
    }

    public void create(Task task) throws Exception {
        if (task.getDeadLine().isBefore(LocalDateTime.now())) {
            throw new Exception("La date limite ne peut pas être dans le passé.");
        }

        if (task.getDeadLine().isAfter(LocalDateTime.now().plusDays(3))) {
            throw new Exception("La date limite ne peut pas dépasser 3 jours à l'avance.");
        }

        if (task.getTags() == null || task.getTags().size() < 2) {
            throw new Exception("Une tâche doit avoir au moins deux tags.");
        }

        taskRepository.save(task);
    }

    public void update(Task task) throws Exception {
        if (task.getStatus().equals(org.example.model.enums.TaskStatus.COMPLETED)
                && task.getDeadLine().isBefore(LocalDateTime.now())) {
            throw new Exception("Vous ne pouvez pas marquer une tâche comme terminée après la date limite.");
        }

        taskRepository.update(task);
    }

    public void delete(Long id, boolean isManagerTask, int tokensRemaining) throws Exception {
        Optional<Task> task = taskRepository.findById(id);

        if (task.isPresent()) {
            if (isManagerTask) {
                if (tokensRemaining <= 0) {
                    throw new Exception("Vous n'avez plus de jetons pour supprimer les tâches du manager.");
                }
            }
            taskRepository.delete(task.get());
        } else {
            throw new Exception("Tâche introuvable.");
        }
    }

}
