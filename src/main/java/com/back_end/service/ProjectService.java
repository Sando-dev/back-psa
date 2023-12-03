package com.back_end.service;

import com.back_end.exceptions.InvalidDateException;
import com.back_end.exceptions.ProjectNotFoundException;
import com.back_end.repository.ProjectRepository;
import com.back_end.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.back_end.model.Project;

import java.time.LocalDate;
import java.util.*;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;
    @Autowired
    private TaskRepository taskRepository;

    public Project createProject(Project project) {
        dateVerification(project.getFechaInicio(), project.getFechaFin());
        return projectRepository.save(project);
    }

    public Project getProject(Long id) {
        Project project = projectRepository.findProjectById(id);

        if (project == null) {
            throw new ProjectNotFoundException("Project not found");
        }
        return project;
    }

    public List<Project> getProjects() {
        return projectRepository.findAll();
    }

    public Optional<Project> findByProjectID(Long project_id) {
        Optional<Project> project = projectRepository.findById(project_id);

        if (project.isEmpty()) {
            throw new ProjectNotFoundException("Project not found");
        }
        return project;
    }

    public void save(Project project) {
        projectRepository.save(project);
    }

    public void deleteByProjectId(Long project_id) {
        projectRepository.deleteById(project_id);
    }

    public void updateProject(Project newProject) {
        getProject(newProject.getId());
        dateVerification(newProject.getFechaInicio(), newProject.getFechaFin());
        save(newProject);
    }

    public Project createProjectWithEstado(String estado) {
        Project project = new Project();
        project.setEstado(estado);
        return project;
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