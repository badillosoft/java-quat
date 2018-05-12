package com.badillosoft.service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.badillosoft.repository.EmpleadoDAO;
import com.badillosoft.model.EmpleadoDTO;

@Service
public class EmpleadoService {

	@Autowired
	EmpleadoDAO empleadoDao;

	public EmpleadoDTO registrarEmpleado(EmpleadoDTO empleado) {
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

	public EmpleadoDTO buscarEmpleado(Long id) {
		Optional<EmpleadoDTO> empleadoOptional = empleadoDao.findById(id);

		if (!empleadoOptional.isPresent()) {
			return null;
		}

		EmpleadoDTO empleado = empleadoOptional.get();

		return empleado;
	}

	public void borrarEmpleado(Long id) throws Exception {
		EmpleadoDTO empleado = new EmpleadoDTO();
		empleado = buscarEmpleado(id);
		if (empleado != null) {
			empleadoDao.deleteById(id);
		} else {
			throw new Exception("Empleado no existe");
		}

	}

}