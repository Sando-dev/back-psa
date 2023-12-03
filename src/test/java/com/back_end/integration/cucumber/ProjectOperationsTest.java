package com.back_end.integration.cucumber;

import com.back_end.model.Project;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;

import java.text.ParseException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ProjectOperationsTest extends ProjectIntegrationServiceTest {
    private Project project;

    @Before
    public void setup() {
        System.out.println("Before any test execution");
    }

    /*
    @Given("^Hay un proyecto en estado (.+)$")
    public void hay_un_proyecto_en_estado(String estado) {
        project = createProject();
        updateEstado(project,estado);
    }

    @When("^El gerente de proyecto cambia el estado del proyecto a (.+)$")
    public void el_gerente_de_proyecto_cambia_el_estado_del_proyecto_a(String estado) {
        updateEstado(project,estado);
    }*/

    @Then("^El estado del proyecto pasa a ser (.+)$")
    public void el_estado_del_proyecto_pasa_a_ser(String estado_actual) {
        assertEquals(estado_actual, project.getEstado());
    }



    /*
    @Given("Project with no tasks")
    public void project_with_no_tasks() {
        project = createProject();
    }

    @When("")
    */

    @After
    public void tearDown() {
        System.out.println("After all test execution");
    }
}
