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
import java.text.SimpleDateFormat;
import java.util.Collection;
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
    public Project createProject(@RequestBody Project project) {
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

    @PutMapping("/projects/{project_id}")
    public ResponseEntity<Object> updateProject(@PathVariable Long project_id,
                                                @RequestParam(required = false) String lider,
                                                @RequestParam(required = false) String nombre,
                                                @RequestParam(required = false) String fechaInicio,
                                                @RequestParam(required = false) String fechaFin,
                                                @RequestParam(required = false) String estado) {
        try {
            Optional<Project> projectOptional = projectService.findByProjectID(project_id);

            if (projectOptional.isEmpty()) {
                return ResponseEntity.notFound().build();
            }

            Project project = projectOptional.get();

            projectService.updateProject(project, lider, nombre, fechaInicio, fechaFin, estado);
            return ResponseEntity.ok().build();
        } catch (ParseException e) {

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid date format");
        }
    }


    @DeleteMapping("/projects/{project_id}")
    public void deleteProject(@PathVariable Long project_id) {
        projectService.deleteByProjectId(project_id);
    }

    @PostMapping("/tasks")
    @ResponseStatus(HttpStatus.CREATED)
    public Task createTask(@RequestBody Task task) {
        return taskService.createTask(task);
    }

    @GetMapping("/tasks/projects/{project_id}")
    public Collection<Task> getTasks(@PathVariable Long project_id) {
        return taskService.findByProjectId(project_id);
    }

    @GetMapping("/tasks/{task_id}")
    public ResponseEntity<Task> getTask(@PathVariable Long task_id) {
        Optional<Task> taskOptional = taskService.findByTaskId(task_id);
        return ResponseEntity.of(taskOptional);
    }

    @PutMapping("/tasks/{task_id}/{project_id}")
    public ResponseEntity<Object> updateTask(@PathVariable Long task_id, @PathVariable Long project_id,
                                             @PathVariable String estado, @PathVariable String fechaInicio,
                                             @PathVariable String fechaFin, @PathVariable String prioridad,
                                             @PathVariable String titulo,  @PathVariable String descripcion,
                                             @PathVariable String asignado) throws ParseException {
        Optional<Task> taskOptional = taskService.findByTaskId(task_id);
        Task task = taskService.getTask(task_id);
        Project project = projectService.getProject(project_id);

        if (!taskOptional.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

        task.setFechaInicio(formatter.parse(fechaInicio));
        task.setFechaFin(formatter.parse(fechaFin));
        task.setProject(project);
        task.setEstado(estado);
        task.setPrioridad(prioridad);
        task.setTitulo(titulo);
        task.setDescripcion(descripcion);
        task.setAsignado(asignado);

        taskService.save(task);
        return ResponseEntity.ok().build();
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
