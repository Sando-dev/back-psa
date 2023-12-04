package com.back_end.integration.cucumber;

import com.back_end.PSAApp;
import com.back_end.model.Task;
import com.back_end.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;

import java.time.LocalDate;

@ContextConfiguration(classes = PSAApp.class)
@WebAppConfiguration
public class TaskIntegrationServiceTest {
    @Autowired
    TaskService taskService;

    Task createTask() {
        Task task = new Task();
        task.setFechaInicio(LocalDate.parse("2025-01-01"));
        task.setFechaFin(LocalDate.parse("2025-12-31"));

        return taskService.createTask(task);
    }

    void updateTask(Task task, String estado, String asignado, Long projectId, String fechaInicio, String fechaFin,
                    String prioridad, String titulo, String descripcion) {
        task.setEstado(estado);
        task.setPrioridad(prioridad);
        task.setTitulo(titulo);
        task.setDescripcion(descripcion);
        task.setAsignado(asignado);

        if (projectId != null) {
            task.setProjectId(projectId);
        }
        if (fechaInicio != null) {
            task.setFechaInicio(LocalDate.parse(fechaInicio));
        }
        if (fechaFin != null) {
            task.setFechaFin(LocalDate.parse(fechaFin));
        }
        taskService.updateTask(task);
    }
}