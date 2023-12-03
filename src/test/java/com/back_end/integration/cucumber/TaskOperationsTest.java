package com.back_end.integration.cucumber;

import com.back_end.model.Task;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.Assert.assertEquals;

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

    @When("^El integrante del proyecto cambia el estado de la tarea a (.*)$")
    public void el_integrante_cambia_el_estado(String estado) {
        task.setEstado(estado);
    }

    @Then("^El estado de la tarea se mantiene en (.*)$")
    public void el_estado_de_la_tarea_se_mantiene_en(String estado) {
        assertEquals(task.getEstado(), estado);
    }

    @Then("^El estado de la tarea pasa a ser (.*)$")
    public void el_estado_de_la_tarea_pasa_a_ser(String estado) {
        assertEquals(task.getEstado(), estado);
    }

    @After
    public void tearDown() {
        System.out.println("After all test execution");
    }
}