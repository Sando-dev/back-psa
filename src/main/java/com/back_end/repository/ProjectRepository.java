package com.back_end.repository;

import com.back_end.model.Project;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface ProjectRepository extends CrudRepository<Project, Long> {

    Project findProjectById(Long id);

    @Override
    List<Project> findAll();
}