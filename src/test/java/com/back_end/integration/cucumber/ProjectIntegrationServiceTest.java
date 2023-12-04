package com.back_end.integration.cucumber;

import com.back_end.PSAApp;
import com.back_end.model.Project;
import com.back_end.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;

import java.time.LocalDate;

@ContextConfiguration(classes = PSAApp.class)
@WebAppConfiguration
public class ProjectIntegrationServiceTest {
    @Autowired
    ProjectService projectService;

    Project createProject() {
        return projectService.createProject(new Project());
    }

    void updateProject(Project project, String estado, String lider, String nombre, String fechaInicio, String fechaFin) {
        project.setLider(lider);
        project.setNombre(nombre);
        project.setEstado(estado);

        if (fechaInicio != null) {
            project.setFechaInicio(LocalDate.parse(fechaInicio));
        }
        if (fechaFin != null) {
            project.setFechaFin(LocalDate.parse(fechaFin));
        }
        projectService.updateProject(project);
    }
}