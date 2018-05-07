package com.quat.dto;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table (name = "Asignacion")
public class AsignacionDTO {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) // para que genere autoincremento en la base de datos
	Long ionId;
	
	 @ManyToOne
	 ProyectoDTO ionProyecto;
	 
	 String ionTipoAsignacion;
	 
	 Timestamp ionFechaInicio;
	 
	 Timestamp ionFechaFin;
	 
	 Boolean ionStatus;

	public Long getIonId() {
		return ionId;
	}

	public ProyectoDTO getIonProyecto() {
		return ionProyecto;
	}

	public String getIonTipoAsignacion() {
		return ionTipoAsignacion;
	}

	public Timestamp getIonFechaInicio() {
		return ionFechaInicio;
	}

	public Timestamp getIonFechaFin() {
		return ionFechaFin;
	}

	public Boolean getIonStatus() {
		return ionStatus;
	}

	public void setIonId(Long ionId) {
		this.ionId = ionId;
	}

	public void setIonProyecto(ProyectoDTO ionProyecto) {
		this.ionProyecto = ionProyecto;
	}

	public void setIonTipoAsignacion(String ionTipoAsignacion) {
		this.ionTipoAsignacion = ionTipoAsignacion;
	}

	public void setIonFechaInicio(Timestamp ionFechaInicio) {
		this.ionFechaInicio = ionFechaInicio;
	}

	public void setIonFechaFin(Timestamp ionFechaFin) {
		this.ionFechaFin = ionFechaFin;
	}

	public void setIonStatus(Boolean ionStatus) {
		this.ionStatus = ionStatus;
	}
	 

}
