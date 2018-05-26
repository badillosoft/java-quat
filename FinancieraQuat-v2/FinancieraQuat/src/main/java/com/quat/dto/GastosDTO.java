package com.quat.dto;

import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.lang.NonNull;

@Entity
@Table(name = "Gastos")

public class GastosDTO {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) // para que genere autoincremento en la base de datos
	Long tosId;

	@ManyToOne
	ProyectoDTO tosProyecto;
	@NonNull
	Date tosFecha;
	@NonNull
	Double tosImporte;
	@NotNull
	String tosDescripcion;

	public Long getTosId() {
		return tosId;
	}

	public ProyectoDTO getTosProyecto() {
		return tosProyecto;
	}

	public Double getTosImporte() {
		return tosImporte;
	}

	public String getTosDescripcion() {
		return tosDescripcion;
	}

	public void setTosId(Long tosId) {
		this.tosId = tosId;
	}

	public void setTosProyecto(ProyectoDTO tosProyecto) {
		this.tosProyecto = tosProyecto;
	}

	public void setTosImporte(Double tosImporte) {
		this.tosImporte = tosImporte;
	}

	public void setTosDescripcion(String tosDescripcion) {
		this.tosDescripcion = tosDescripcion;
	}

	public Date getTosFecha() {
		return tosFecha;
	}

	public void setTosFecha(Date tosFecha) {
		this.tosFecha = tosFecha;
	}

}
