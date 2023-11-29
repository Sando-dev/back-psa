package com.back_end.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@ApiModel(description = "Detalles de la tarea")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @ApiModelProperty(notes = "ID de la tarea (generado automáticamente)", example = "0")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "project_id", nullable = false)
    private Project project;

    @ApiModelProperty(notes = "Estado de la tarea", example = "No Iniciada")
    private String estado;

    @JsonFormat(pattern = "yyyy-MM-dd")
    //@Temporal(TemporalType.DATE)
    @ApiModelProperty(notes = "Fecha de inicio de la tarea (formato: yyyy-MM-dd)", example = "2023-11-20")
    private Date fechaInicio;

    @JsonFormat(pattern = "yyyy-MM-dd")
    //@Temporal(TemporalType.DATE)
    @ApiModelProperty(notes = "Fecha de finalización de la tarea (formato: yyyy-MM-dd)", example = "2023-12-31")
    private Date fechaFin;

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

    public Task(Project project, String estado, Date fechaInicio, Date fechaFin,
                String prioridad, String titulo, String descripcion, String asignado) {
        this.project = project;
        this.estado = estado;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.prioridad = prioridad;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.asignado = asignado;
    }

    public Project getProject() {
        return this.project;
    }

    public Long getId() {
        return this.id;
    }

    public String getEstado() {
        return this.estado;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public Date getFechaFin() {
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

    public void setProject(Project project) {
        this.project = project;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public void setFechaFin(Date fechaFin) {
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