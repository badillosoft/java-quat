package com.quat.service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quat.dao.AsignacionDAO;
import com.quat.dao.EmpleadoDAO;
import com.quat.dto.AsignacionDTO;
import com.quat.dto.EmpleadoDTO;
import com.quat.dto.ProyectoDTO;

@Service
public class EmpleadoService {
	
	@Autowired
	EmpleadoDAO empleadoDao;
	
	@Autowired
	AsignacionDAO asignacionDao;
	
	
	public EmpleadoDTO registrarEmpleado(EmpleadoDTO empleado) {
		empleado.setAdoAsignaciones(new HashSet<>());
		empleadoDao.save(empleado);
		return empleado;
	}
	
	public EmpleadoDTO asignarNomina(EmpleadoDTO empleado, String tipoNomina) {
		empleado.setAdoTipoNomina(tipoNomina);
		empleadoDao.save(empleado);
		return empleado;
	}
	
	public EmpleadoDTO asignarPuesto(EmpleadoDTO empleado, String puesto) {
		empleado.setAdoPuesto(puesto);
		empleadoDao.save(empleado);
		return empleado;
	}
	
	public EmpleadoDTO asignarSueldo(EmpleadoDTO empleado, Double sueldo) {
		empleado.setAdoSueldo(sueldo);
		empleadoDao.save(empleado);
		return empleado;
	}
	
	public EmpleadoDTO altaAsignacion(EmpleadoDTO empleado, ProyectoDTO proyecto) {
		AsignacionDTO asignacion = new AsignacionDTO();
		asignacion.setIonProyecto(proyecto);
		asignacion.setIonStatus(true);
		asignacion.setIonFechaInicio(Timestamp.valueOf(LocalDateTime.now()));
		asignacionDao.save(asignacion);
		Set<AsignacionDTO> asignaciones = empleado.getAdoAsignaciones();
		asignaciones.add(asignacion);
		empleadoDao.save(empleado);
		return empleado;
	}
	
	public EmpleadoDTO bajaAsignacion(EmpleadoDTO empleado, AsignacionDTO asignacion) throws Exception {
		Set<AsignacionDTO> asignaciones = empleado.getAdoAsignaciones();
		if(!asignaciones.contains(asignacion)) {
			throw new Exception("El Empleado no tiene la asignacion");
		}
		asignacion.setIonFechaFin(Timestamp.valueOf(LocalDateTime.now()));
		asignacion.setIonStatus(false);
		asignacionDao.save(asignacion);
		return empleado;
	}
	
}
