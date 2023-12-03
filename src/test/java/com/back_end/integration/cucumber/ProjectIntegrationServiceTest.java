package com.back_end.integration.cucumber;

import com.back_end.PSAApp;
import com.back_end.model.Project;
import com.back_end.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;

@ContextConfiguration(classes = PSAApp.class)
@WebAppConfiguration
public class ProjectIntegrationServiceTest {
    @Autowired
    ProjectService projectService;

    Project createProject() {
        return projectService.createProject(new Project());
    }
}