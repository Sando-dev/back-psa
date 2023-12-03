package com.back_end;

import com.back_end.model.Project;
import com.back_end.model.Task;
import com.back_end.service.ProjectService;
import com.back_end.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.text.ParseException;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@SpringBootApplication
@EnableSwagger2
public class PSAApp {

    @Autowired
    private ProjectService projectService;
    @Autowired
    private TaskService taskService;

    public static void main(String[] args) {
        SpringApplication.run(PSAApp.class, args);
    }

    @PostMapping("/projects")
    @ResponseStatus(HttpStatus.CREATED)
    public Project createProject(@RequestBody Project project) throws ParseException {
        return projectService.createProject(project);
    }

    @GetMapping("/projects")
    public Collection<Project> getProjects() {
        return projectService.getProjects();
    }

    @GetMapping("/projects/{project_id}")
    public ResponseEntity<Project> getProject(@PathVariable Long project_id) {
        Optional<Project> projectOptional= projectService.findByProjectID(project_id);
        return ResponseEntity.of(projectOptional);
    }

    @GetMapping("/projects/{project_id}/tasks")
    public Collection<Task> getTasksByProject(@PathVariable Long project_id) {
        return taskService.findByProjectId(project_id);
    }

    @PutMapping("/projects")
    public Project updateProject(@RequestBody Project newProject) throws ParseException {
        projectService.updateProject(newProject);
        return newProject;
    }

    @DeleteMapping("/projects/{project_id}")
    public void deleteProject(@PathVariable Long project_id) {
        projectService.deleteByProjectId(project_id);
    }

    @PostMapping("/tasks")
    @ResponseStatus(HttpStatus.CREATED)
    public Task createTask(@RequestBody Task task) throws ParseException {
        return taskService.createTask(task);
    }

    @GetMapping("/tasks")
    public List<Task> getTasks() {
        return taskService.getTasks();
    }

    @GetMapping("/tasks/{task_id}")
    public Task getTask(Long task_id) {
        return taskService.getTask(task_id);
    }

    @PutMapping("/tasks")
    public Task updateTask(@RequestBody Task newTask) throws ParseException {
        projectService.getProject(newTask.getProjectId());
        taskService.updateTask(newTask);
        return newTask;
    }

    @DeleteMapping("/tasks/{task_id}")
    public void deleteTask(@PathVariable Long task_id) {
        taskService.deleteByTaskId(task_id);
    }

    @Bean
    public Docket apiDocket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
    }
}
