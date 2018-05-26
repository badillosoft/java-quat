package com.quat.dto;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Proyecto")
public class ProyectoDTO {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) // para que genere autoincremento en la base de datos
	Long ctoId;

	@NotNull
	String ctoDescripcion;
	@NotNull
	String ctoNombre;
	@NotNull
	String ctoAplicativo;
	@NotNull
	Date ctoFechaInicio;

	Date ctoFechaFin;

	Double ctoPresupuesto;

	public Long getCtoId() {
		return ctoId;
	}

	public String getCtoDescripcion() {
		return ctoDescripcion;
	}

	public String getCtoNombre() {
		return ctoNombre;
	}

	public String getCtoAplicativo() {
		return ctoAplicativo;
	}

	public Double getCtoPresupuesto() {
		return ctoPresupuesto;
	}

	public void setCtoId(Long ctoId) {
		this.ctoId = ctoId;
	}

	public void setCtoDescripcion(String ctoDescripcion) {
		this.ctoDescripcion = ctoDescripcion;
	}

	public void setCtoNombre(String ctoNombre) {
		this.ctoNombre = ctoNombre;
	}

	public void setCtoAplicativo(String ctoAplicativo) {
		this.ctoAplicativo = ctoAplicativo;
	}

	public void setCtoPresupuesto(Double ctoPresupuesto) {
		this.ctoPresupuesto = ctoPresupuesto;
	}

	public Date getCtoFechaInicio() {
		return ctoFechaInicio;
	}

	public Date getCtoFechaFin() {
		return ctoFechaFin;
	}

	public void setCtoFechaInicio(Date ctoFechaInicio) {
		this.ctoFechaInicio = ctoFechaInicio;
	}

	public void setCtoFechaFin(Date ctoFechaFin) {
		this.ctoFechaFin = ctoFechaFin;
	}

}
