package com.back_end.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@ApiModel(description = "Detalles del proyecto")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @ApiModelProperty(notes = "ID del proyecto (generado automáticamente)", example = "0")
    private Long id;

    @ApiModelProperty(notes = "Nombre del líder del proyecto", example = "Augusto Aguanti")
    private String lider;

    @ApiModelProperty(notes = "Estado del proyecto ('No Iniciado' por defecto)", example = "No Iniciado")
    private String estado;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @ApiModelProperty(notes = "Fecha de inicio del proyecto (formato: yyyy-MM-dd)", example = "2023-12-20")
    private LocalDate fechaInicio;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @ApiModelProperty(notes = "Fecha de finalización del proyecto (formato: yyyy-MM-dd)", example = "2023-12-31")
    private LocalDate fechaFin;

    @ApiModelProperty(notes = "Nombre del proyecto", example = "SIU Guarani")
    private String nombre;

    public Project() {
    }

    public Project(String lider, String nombre, LocalDate fechaInicio, LocalDate fechaFin) {
        this.lider = lider;
        this.estado = "No Iniciado";
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.nombre = nombre;
    }

    public Long getId() {
        return id;
    }

    public String getLider() {
        return lider;
    }

    public String getEstado() {
        return estado;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public String getNombre() {
        return nombre;
    }

    public void setLider(String lider) {
        this.lider = lider;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public void setFechaFin (LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}