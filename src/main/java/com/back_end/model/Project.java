package com.back_end.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;

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
    @Temporal(TemporalType.DATE)
    @ApiModelProperty(notes = "Fecha de inicio del proyecto (formato: yyyy-MM-dd)", example = "2023-11-20")
    private Date fechaInicio;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    @ApiModelProperty(notes = "Fecha de finalización del proyecto (formato: yyyy-MM-dd)", example = "2023-12-31")
    private Date fechaFin;

    @ApiModelProperty(notes = "Nombre del proyecto", example = "SIU Guarani")
    private String nombre;

    public Project() {
    }

    public Project(String lider, String nombre, Date fechaInicio, Date fechaFin) {
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

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public Date getFechaFin() {
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

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public void setFechaFin (Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}