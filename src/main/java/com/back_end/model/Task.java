package com.back_end.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@ApiModel(description = "Detalles de la tarea")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @ApiModelProperty(notes = "ID de la tarea (generado automáticamente)", example = "0")
    private Long id;

    @JoinColumn(name = "projectId", nullable = false)
    private Long projectId;

    @ApiModelProperty(notes = "Estado de la tarea", example = "No Iniciada")
    private String estado;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @ApiModelProperty(notes = "Fecha de inicio de la tarea (formato: yyyy-MM-dd)", example = "2023-12-20")
    private LocalDate fechaInicio;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @ApiModelProperty(notes = "Fecha de finalización de la tarea (formato: yyyy-MM-dd)", example = "2023-12-31")
    private LocalDate fechaFin;

    @ApiModelProperty(notes = "Prioridad de la tarea", example = "Alta")
    private String prioridad;

    @ApiModelProperty(notes = "Título de la tarea", example = "Implementar funcionalidad X")
    private String titulo;

    @ApiModelProperty(notes = "Descripción de la tarea", example = "Implementar funcionalidad X")
    private String descripcion;

    @ApiModelProperty(notes = "Persona asignada a la tarea", example = "Juan Perez")
    private String asignado;

    public Task() {
    }

    public Task(Long projectId, String estado, LocalDate fechaInicio, LocalDate fechaFin,
                String prioridad, String titulo, String descripcion, String asignado) {
        this.projectId = projectId;
        this.estado = estado;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.prioridad = prioridad;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.asignado = asignado;
    }

    public Long getProjectId() {
        return this.projectId;
    }

    public Long getId() {
        return this.id;
    }

    public String getEstado() {
        return this.estado;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public String getPrioridad() {
        return prioridad;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getAsignado() {
        return asignado;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    public void setPrioridad(String prioridad) {
        this.prioridad = prioridad;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setAsignado(String asignado) {
        this.asignado = asignado;
    }
}