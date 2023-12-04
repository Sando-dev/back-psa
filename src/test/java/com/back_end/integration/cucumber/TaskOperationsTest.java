package com.back_end.integration.cucumber;

import com.back_end.model.Task;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.jupiter.api.Assertions;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class TaskOperationsTest extends TaskIntegrationServiceTest {
    private Task task;

    @Before
    public void setup() {
        System.out.println("Before any test execution");
    }

    @Given("^Una tarea en estado (.*)$")
    public void tarea_en_estado(String estado) {
        task = createTask();
        //task.setEstado(estado);
        updateTask(task, estado, null, null, null, null, null, null, null);
    }

    @Given("^Una tarea creada$")
    public void una_tarea_creada_y_dos_integrantes() {
        task = createTask();
    }

    @Given("^Una tarea creada y el integrante (.*) está asignado a la tarea$")
    public void una_tarea_creada_integrante_asignado(String nombre) {
        task = createTask();
        //task.setAsignado(nombre);
        updateTask(task, null, nombre, null, null, null, null, null, null);
    }

    @Given("^Una tarea A creada y otra tarea B creada y el integrante (.*) está asignado a la tarea A$")
    public void una_tarea_con_integrante_y_otra_creada(String nombre) {
        Task taskA = createTask();
        //taskA.setAsignado(nombre);
        updateTask(taskA, null, nombre, null, null, null, null, null, null);
        task = createTask();
    }

    @Given("^No hay tareas creadas$")
    public void no_hay_tareas_creadas() {}

    @Given("^Hay (\\d+) tareas creadas$")
    public void hay_tareas_creadas(int cantidad) {
        Long project_id = 0L;
        for (int i = 0; i < cantidad; i++) {
            Task task = createTask();

            updateTask(task, "En progreso", "Augusto Aguanti", project_id, "2025-01-01",
                    "2025-12-31", "Baja", "Ejemplo", "Ejemplo");
        }
    }

    @When("^El integrante del proyecto cambia el estado de la tarea a (.*)$")
    public void el_integrante_cambia_el_estado(String estado) {
        //task.setEstado(estado);
        updateTask(task, estado, null, null, null, null, null, null, null);
    }

    @When("^El integrante de proyecto Juan asigna a (.*) como responsable$")
    public void el_integrante_de_proyecto_asigna_responsable(String nombre) {
        //task.setAsignado(nombre);
        updateTask(task, null, nombre, null, null, null, null, null, null);
    }

    @When("^El integrante de proyecto (.*) se asigna la tarea a sí mismo$")
    public void el_integrante_de_proyecto_se_asigna(String nombre) {
        //task.setAsignado(nombre);
        updateTask(task, null, nombre, null, null, null, null, null, null);
    }

    @When("^El integrante de proyecto Juan se quita la asignación$")
    public void el_integrante_de_proyecto_se_quita() {
        //task.setAsignado(null);
        updateTask(task, null, null, null, null, null, null, null, null);
    }

    @When("^El integrante de proyecto (.*) se asigna la tarea B$")
    public void el_integrante_se_asigna_la_tarea_b(String nombre) {
        //task.setAsignado(nombre);
        updateTask(task, null, nombre, null, null, null, null, null, null);
    }

    @When("^El integrante de proyecto consulta el tablero del proyecto$")
    public void el_integrante_consulta_el_tablero() {
        assertNotNull(taskService.getTasks());
    }

    @When("^El integrante de proyecto edita la tarea número (\\d+)$")
    public void el_integrante_de_proyecto_edita_tarea(int orden) {
        Task task = taskService.getTask((long)(orden - 1));
        task.setTitulo("Edición tarea");
        task.setDescripcion("Prueba de edición tarea");
        task.setPrioridad("Alta");
        updateTask(task, null, null, null, null, null,
                "Alta", "Edición tarea", "Prueba de edición tarea");
        //taskService.save(task);
    }

    @Then("^El estado de la tarea se mantiene en (.*)$")
    public void el_estado_de_la_tarea_se_mantiene_en(String estado) {
        assertEquals(task.getEstado(), estado);
    }

    @Then("^El estado de la tarea pasa a ser (.*)$")
    public void el_estado_de_la_tarea_pasa_a_ser(String estado) {
        assertEquals(task.getEstado(), estado);
    }

    @Then("^La tarea pasa a tener como asignado a (.*)$")
    public void la_tarea_pasa_a_tener_asignado_a(String nombre) {
        assertEquals(task.getAsignado(), nombre);
    }

    @Then("^La tarea pasa a no tener asignados$")
    public void la_tarea_no_tiene_asignados() {
        assertNull(task.getAsignado());
    }

    @Then("^La tarea B pasa a tener asignado a (.*)$")
    public void la_tarea_b_tiene_asignado(String nombre) {
        assertEquals(task.getAsignado(), nombre);
    }

    @Then("^Se le muestra que no hay tareas creadas$")
    public void muestra_no_hay_tareas_creadas() {
        Assertions.assertEquals(taskService.getTasks().size(), 0);
    }

    @Then("^Se le muestran las (\\d+) tareas creadas con sus respectivos titulos, prioridades, asignados, estados, descripciones, inicio y fin$")
    public void se_muestran_las_tareas_con_sus_atributos(int cantidad) {
        for (Task task : taskService.findByProjectId(0L)) {
            Assertions.assertEquals(task.getTitulo(), "Ejemplo");
            Assertions.assertEquals(task.getPrioridad(), "Baja");
            Assertions.assertEquals(task.getAsignado(), "Augusto Aguanti");
            Assertions.assertEquals(task.getEstado(), "En progreso");
            Assertions.assertEquals(task.getDescripcion(), "Ejemplo");
            Assertions.assertEquals(task.getFechaInicio(), LocalDate.parse("2025-01-01"));
            Assertions.assertEquals(task.getFechaFin(), LocalDate.parse("2025-12-31"));
        }
    }

    @Then("^Se le informa que la edición de la tarea número (\\d+) fue exitosa$")
    public void la_edicion_de_la_tarea_fue_exitosa(int orden) {
        Task task = taskService.getTask((long)(orden - 1));
        assertEquals(task.getTitulo(), "Edición tarea");
        assertEquals(task.getDescripcion(), "Prueba de edición tarea");
        assertEquals(task.getPrioridad(), "Alta");
    }

    @After
    public void tearDown() {
        System.out.println("After all test execution");
    }
}