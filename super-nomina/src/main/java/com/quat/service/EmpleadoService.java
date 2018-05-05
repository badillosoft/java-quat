package com.quat.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.quat.model.Empleado;
import com.quat.reposity.EmpleadoRepository;

@Service
public class EmpleadoService {

	@Autowired
	EmpleadoRepository empleadoRepository;
	
	public Empleado crearEmpleado(Empleado empleado) {
		empleadoRepository.save(empleado);
		return empleado;
	}
	
	String lastMessage = "";
	
	public String getLastMessage() {
		return lastMessage;
	}

	public Empleado asignarSueldo(Long idEmpleado, double sueldo) {
		Optional<Empleado> empleadoOptional = empleadoRepository.findById(idEmpleado);
		
		if (!empleadoOptional.isPresent()) {
			lastMessage = "El empleado no existe";
			return null;
		}
		
		Empleado empleado = empleadoOptional.get();
		
		if (empleado.getSueldo() != null) {
			lastMessage = "El empleado ya tiene un sueldo asignado, utiliza /api/empleado/{id}/reasignar/sueldo";
			return null;
		}
		
		if (sueldo < 0) {
			lastMessage = "El sueldo no es válido";
			return null;
		}
		
		empleado.setSueldo(sueldo);
		
		empleadoRepository.save(empleado);
		
		return empleado;
	}
	
}
