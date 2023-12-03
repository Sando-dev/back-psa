package com.back_end.service;

import com.back_end.exceptions.InvalidDateException;
import com.back_end.exceptions.TaskNotFoundException;
import com.back_end.model.Task;
import com.back_end.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;

@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;

    public Task createTask (Task task) {
        dateVerification(task.getFechaInicio(), task.getFechaFin());
        return taskRepository.save(task);
    }

    public Task getTask(Long id) {
        Task task = taskRepository.findTaskById(id);

        if (task == null) {
            throw new TaskNotFoundException("Task not found");
        }
        return task;
    }

    public List<Task> getTasks() {
        return taskRepository.findAll();
    }

    public Optional<Task> findByTaskId(Long id) {
        return taskRepository.findById(id);
    }

    public ArrayList<Task> findByProjectId(Long project_id) {
        List<Task> taskList = taskRepository.findAll();
        ArrayList<Task> projectTasks = new ArrayList<Task>();

        for (Task task : taskList) {
            if (Objects.equals(task.getProjectId(), project_id)) {
                projectTasks.add(task);
            }
        }
        return projectTasks;
    }

    public void save(Task task) {
        taskRepository.save(task);
    }

    public void deleteByTaskId(Long id) {
        taskRepository.deleteById(id);
    }

    public void updateTask(Task newTask) {
        getTask(newTask.getId());
        dateVerification(newTask.getFechaInicio(), newTask.getFechaFin());
        save(newTask);
    }

    private void dateVerification(LocalDate startDate, LocalDate endDate) {
        LocalDate actualDate = LocalDate.now();

        if (startDate.isBefore(actualDate)) {
            throw new InvalidDateException("Cannot set start date before actual date");
        } else if (endDate.isBefore(actualDate)) {
            throw new InvalidDateException("Cannot set end date before actual date");
        } else if (startDate.isAfter(endDate)) {
            throw new InvalidDateException("Cannot set start date after end date");
        }
    }
}