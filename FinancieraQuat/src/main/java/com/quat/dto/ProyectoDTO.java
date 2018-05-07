package com.quat.dto;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Proyecto")
public class ProyectoDTO {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) // para que genere autoincremento en la base de datos
	Long ctoId;

	String ctoDescripcion;
	
	String ctoNombre;
	
	String ctoAplicativo;
	
	Timestamp ctoFechaInicio;
	
	Timestamp ctoFechaFin;
	
	Long ctoPresupuesto;

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

	public Timestamp getCtoFechaInicio() {
		return ctoFechaInicio;
	}

	public Timestamp getCtoFechaFin() {
		return ctoFechaFin;
	}

	public Long getCtoPresupuesto() {
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

	public void setCtoFechaInicio(Timestamp ctoFechaInicio) {
		this.ctoFechaInicio = ctoFechaInicio;
	}

	public void setCtoFechaFin(Timestamp ctoFechaFin) {
		this.ctoFechaFin = ctoFechaFin;
	}

	public void setCtoPresupuesto(Long ctoPresupuesto) {
		this.ctoPresupuesto = ctoPresupuesto;
	}
	
	

	
}
