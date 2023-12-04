package com.back_end.integration.cucumber;

import com.back_end.model.Task;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class TaskOperationsTest extends TaskIntegrationServiceTest {
    private Task task;

    @Before
    public void setup() {
        System.out.println("Before any test execution");
    }

    @Given("^Una tarea en estado (.*)$")
    public void tarea_en_estado(String estado) {
        task = createTask();
        task.setEstado(estado);
    }

    @Given("^Una tarea creada$")
    public void una_tarea_creada_y_dos_integrantes() {
        task = createTask();
    }

    @Given("^Una tarea creada y el integrante (.*) está asignado a la tarea$")
    public void una_tarea_creada_integrante_asignado(String nombre) {
        task = createTask();
        task.setAsignado(nombre);
    }

    @Given("^Una tarea A creada y otra tarea B creada y el integrante (.*) está asignado a la tarea A$")
    public void una_tarea_con_integrante_y_otra_creada(String nombre) {
        Task taskA = new Task();
        taskA.setAsignado(nombre);
        task = createTask();
    }

    @When("^El integrante del proyecto cambia el estado de la tarea a (.*)$")
    public void el_integrante_cambia_el_estado(String estado) {
        task.setEstado(estado);
    }

    @When("^El integrante de proyecto Juan asigna a (.*) como responsable$")
    public void el_integrante_de_proyecto_asigna_responsable(String nombre) {
        task.setAsignado(nombre);
    }

    @When("^El integrante de proyecto (.*) se asigna la tarea a sí mismo$")
    public void el_integrante_de_proyecto_se_asigna(String nombre) {
        task.setAsignado(nombre);
    }

    @When("^El integrante de proyecto (.*) se quita la asignación$")
    public void el_integrante_de_proyecto_se_quita(String nombre) {
        task.setAsignado(null);
    }

    @When("^El integrante de proyecto (.*) se asigna la tarea B$")
    public void el_integrante_se_asigna_la_tarea_b(String nombre) {
        task.setAsignado(nombre);
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

    @After
    public void tearDown() {
        System.out.println("After all test execution");
    }
}