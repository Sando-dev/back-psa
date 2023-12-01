package com.back_end.integration.cucumber;

import com.back_end.PSAApp;
import com.back_end.model.Project;
import com.back_end.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import java.text.ParseException;

@ContextConfiguration(classes = PSAApp.class)
@WebAppConfiguration
public class ProjectIntegrationServiceTest {
    @Autowired
    ProjectService projectService;

    /*
    Project createProject() {
        return projectService.createProject(new Project());
    }

    void updateEstado(Project project, String estado) throws ParseException {
        projectService.updateProject(project, null, null, null, null, estado);
    }

    Account withdraw(Account account, Double sum) {
        return accountService.withdraw(account.getCbu(), sum);
    }

    Account deposit(Account account, Double sum) {
        return accountService.deposit(account.getCbu(), sum);
    }
    */
}
