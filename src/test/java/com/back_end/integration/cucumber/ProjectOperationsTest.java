package com.back_end.integration.cucumber;

import com.back_end.model.Project;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ProjectOperationsTest extends ProjectIntegrationServiceTest {
    private Project project;

    @Before
    public void setup() {
        System.out.println("Before any test execution");
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
