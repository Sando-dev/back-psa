package com.back_end.service;

import com.back_end.repository.ProjectRepository;
import com.back_end.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.back_end.model.Project;

import java.util.*;
import java.text.SimpleDateFormat;
import java.text.ParseException;

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

    public void updateProject(Project project, String lider, String nombre,
                              String fechaInicio, String fechaFin, String estado) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

        if (fechaInicio != null) {
            project.setFechaInicio(formatter.parse(fechaInicio));
        }
        if (fechaFin != null) {
            project.setFechaFin(formatter.parse(fechaFin));
        }
        if (lider != null) {
            project.setLider(lider);
        }
        if (nombre != null) {
            project.setNombre(nombre);
        }
        if (estado != null) {
            project.setEstado(estado);
        }
        save(project);

    }

    public Project createProjectWithEstado(String estado) {
        Project project = new Project();
        project.setEstado(estado);
        return project;
    }

}