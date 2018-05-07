package com.quat.api;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.quat.dao.EmpleadoDAO;
import com.quat.dto.EmpleadoDTO;
import com.quat.service.EmpleadoService;

@RestController
@RequestMapping("/api/empleado")
public class EmpleadoApiController {
	
	@Autowired
	EmpleadoService empleadoService;
	
	@Autowired
	EmpleadoDAO empleadoDao;
	
	@PutMapping("")/*
	public EmpleadoDTO registrarEmpleado(@RequestParam String adoNombre,
		 	@RequestParam String adoApPaterno,
		 	@RequestParam String adoApMaterno,
		 	@RequestParam String adoDireccion,
		 	@RequestParam Long adoTelefono,
		 	@RequestParam String adoGenero,
		 	@RequestParam Timestamp adoFechaNacimiento,
		 	@RequestParam String adoCorreo,
		 	@RequestParam Timestamp adoFechaIngreso) {
		
		EmpleadoDTO empleado = new EmpleadoDTO();
		
		empleado.setAdoNombre(adoNombre);
		empleado.setAdoApPaterno(adoApPaterno);
		empleado.setAdoApMaterno(adoApMaterno);
		empleado.setAdoDireccion(adoDireccion);
		empleado.setAdoTelefono(adoTelefono);
		empleado.setAdoGenero(adoGenero);
		empleado.setAdoFechaNacimiento(adoFechaNacimiento);
		empleado.setAdoCorreo(adoCorreo);
		empleado.setAdoFechaIngreso(adoFechaIngreso);
		return empleadoService.registrarEmpleado(empleado);
		
	}*/
	public EmpleadoDTO registrarEmpleado(@ModelAttribute EmpleadoDTO empleado) {
		return empleadoService.registrarEmpleado(empleado);
	}
	
}
