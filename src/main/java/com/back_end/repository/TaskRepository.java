package com.back_end.repository;

import com.back_end.model.Project;
import com.back_end.model.Task;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface TaskRepository extends CrudRepository<Task, Long> {

    Task findTaskById(Long id);

    @Override
    List<Task> findAll();
}