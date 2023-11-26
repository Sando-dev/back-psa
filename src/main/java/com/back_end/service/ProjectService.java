package com.back_end.service;


import com.back_end.model.Task;
import com.back_end.repository.ProjectRepository;
import com.back_end.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.back_end.model.Project;

import java.util.*;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;
    @Autowired
    private TaskRepository taskRepository;

    public Project createProject(Project project) {
        return projectRepository.save(project);
    }

    public List<Project> getProjects() {
        return projectRepository.findAll();
    }

    public Optional<Project> findByProjectID(Long project_id) {
        return projectRepository.findById(project_id);
    }

    public void save(Project project) {
        projectRepository.save(project);
    }

    public void deleteByProjectId(Long project_id) {
        projectRepository.deleteById(project_id);
    }

    public Project addTask(Long project_id, String estado, Date fechaInicio, Date fechaFin,
                        String prioridad, String titulo, String descripcion, String asignado) {
        Project project = projectRepository.findProjectById(project_id);
        Task task = new Task(project, estado, fechaInicio, fechaFin, prioridad, titulo, descripcion, asignado);

        taskRepository.save(task);
        return project;
    }

    public Task getTask(Long task_id) {
        return taskRepository.findTaskById(task_id);
    }

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public void deleteTaskById(Long id) {
        taskRepository.deleteById(id);
    }
}