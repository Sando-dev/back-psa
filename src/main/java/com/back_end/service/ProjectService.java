package com.back_end.service;

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

    public Project getProject(Long id) {
        return projectRepository.findProjectById(id);
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
}