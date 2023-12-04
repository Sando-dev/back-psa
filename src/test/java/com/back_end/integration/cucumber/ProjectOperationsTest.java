package com.back_end.integration.cucumber;

import com.back_end.model.Project;
import com.back_end.model.Task;
import com.back_end.service.TaskService;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.ParseException;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ProjectOperationsTest extends ProjectIntegrationServiceTest {
    private Project project;

    @Autowired
    private TaskService taskService;

    @Before
    public void setup() {
        System.out.println("Before any test execution");
    }

    @Given("^No hay tareas registradas para el proyecto (.*)$")
    public void no_hay_tareas_para_el_proyecto(String estado) {
        project = createProject();
        project.setEstado(estado);
        projectService.save(project);
    }

    @Given("^Hay (\\d+) tareas registradas para el proyecto (.*)$")
    public void hay_tareas_para_el_proyecto(int cantidad, String estado) {
        project = createProject();
        project.setEstado(estado);

        for (int i = 0; i < cantidad; i++) {
            Task task = taskService.createTask(new Task());
            task.setProjectId(project.getId());
            task.setFechaInicio(LocalDate.parse("2025-01-01"));
            task.setFechaFin(LocalDate.parse("2025-12-31"));
            task.setDescripcion("Ejemplo");
            task.setAsignado("Augusto Aguanti");
            task.setEstado("En progreso");
            taskService.save(task);
        }
        projectService.save(project);
    }

    @When("^El integrante de proyecto consulta las tareas del proyecto$")
    public void el_integrante_consulta_las_tareas_del_proyecto() {
        assertNotNull(taskService.findByProjectId(project.getId()));
    }

    @Then("^Se le informa que no hay tareas registradas$")
    public void no_hay_tareas_registradas() {
        assertEquals(taskService.findByProjectId(project.getId()).size(), 0);
    }

    @Then("^Se le informa fecha de inicio y fin, descripción, asignado y estado para las (\\d+) tareas$")
    public void se_le_informan_datos_de_ambas_tareas(int cantidad) {
        for (Task task : taskService.findByProjectId(project.getId())) {
            assertEquals(task.getFechaInicio(), LocalDate.parse("2025-01-01"));
            assertEquals(task.getFechaFin(), LocalDate.parse("2025-12-31"));
            assertEquals(task.getDescripcion(), "Ejemplo");
            assertEquals(task.getAsignado(), "Augusto Aguanti");
            assertEquals(task.getEstado(), "En progreso");
        }
    }

    @After
    public void tearDown() {
        System.out.println("After all test execution");
    }
}
