package com.badillosoft.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.OneToMany;
import javax.persistence.Table;

import java.sql.Date;
//import java.util.Set;

import org.springframework.lang.NonNull;

@Entity
@Table(name = "Empleado")
public class EmpleadoDTO {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) // para que genere autoincremento en la base de datos
	Long adoId;
	
	@NonNull
	String adoNombre;
	@NonNull
	String adoApPaterno;
	@NonNull
	String adoApMaterno;
	@NonNull
	String adoDireccion;
	@NonNull
	Long adoTelefono;
	@NonNull
	String adoGenero;
	@NonNull
	Date adoFechaNacimiento;
	@NonNull
	String adoCorreo;
	@NonNull
	Date adoFechaIngreso;
	
	String adoPuesto;
	
	String adoTipoNomina;
	
	Double adoSueldo;
	
	//@OneToMany
	//Set<AsignacionDTO> adoAsignaciones;

	public Long getAdoId() {
		return adoId;
	}

	public String getAdoNombre() {
		return adoNombre;
	}

	public String getAdoApPaterno() {
		return adoApPaterno;
	}

	public String getAdoApMaterno() {
		return adoApMaterno;
	}

	public String getAdoDireccion() {
		return adoDireccion;
	}

	public String getAdoTipoNomina() {
		return adoTipoNomina;
	}

	public Long getAdoTelefono() {
		return adoTelefono;
	}

	public Double getAdoSueldo() {
		return adoSueldo;
	}

	public String getAdoGenero() {
		return adoGenero;
	}

	public String getAdoCorreo() {
		return adoCorreo;
	}

	public String getAdoPuesto() {
		return adoPuesto;
	}

	//public Set<AsignacionDTO> getAdoAsignaciones() {
	//	return adoAsignaciones;
	//}

	public void setAdoId(Long adoId) {
		this.adoId = adoId;
	}

	public void setAdoNombre(String adoNombre) {
		this.adoNombre = adoNombre;
	}

	public void setAdoApPaterno(String adoApPaterno) {
		this.adoApPaterno = adoApPaterno;
	}

	public void setAdoApMaterno(String adoApMaterno) {
		this.adoApMaterno = adoApMaterno;
	}

	public void setAdoDireccion(String adoDireccion) {
		this.adoDireccion = adoDireccion;
	}

	public void setAdoTipoNomina(String adoTipoNomina) {
		this.adoTipoNomina = adoTipoNomina;
	}

	public void setAdoTelefono(Long adoTelefono) {
		this.adoTelefono = adoTelefono;
	}

	public void setAdoSueldo(Double adoSueldo) {
		this.adoSueldo = adoSueldo;
	}

	public void setAdoGenero(String adoGenero) {
		this.adoGenero = adoGenero;
	}

	public void setAdoCorreo(String adoCorreo) {
		this.adoCorreo = adoCorreo;
	}

	public void setAdoPuesto(String adoPuesto) {
		this.adoPuesto = adoPuesto;
	}

	//public void setAdoAsignaciones(Set<AsignacionDTO> adoAsignaciones) {
	//	this.adoAsignaciones = adoAsignaciones;
	//}

	public Date getAdoFechaIngreso() {
		return adoFechaIngreso;
	}

	public void setAdoFechaIngreso(Date adoFechaIngreso) {
		this.adoFechaIngreso = adoFechaIngreso;
	}

	public Date getAdoFechaNacimiento() {
		return adoFechaNacimiento;
	}

	public void setAdoFechaNacimiento(Date adoFechaNacimiento) {
		this.adoFechaNacimiento = adoFechaNacimiento;
	}
	

}