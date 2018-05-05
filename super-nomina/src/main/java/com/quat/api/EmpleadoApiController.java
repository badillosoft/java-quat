package com.quat.api;

import java.io.IOException;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.quat.model.Empleado;
import com.quat.reposity.EmpleadoRepository;
import com.quat.service.EmpleadoService;

@RestController
@RequestMapping("/api/empleado")
public class EmpleadoApiController {

	@Autowired
	EmpleadoService empleadoService;
	
	@Autowired
	EmpleadoRepository empleadoRepository;
	
	@GetMapping("/{id}")
	@ResponseBody
	public Empleado verEmpleado(@PathVariable Long id, HttpServletResponse response) throws IOException {
		Optional<Empleado> empleadoOptional = empleadoRepository.findById(id);
		
		if (!empleadoOptional.isPresent()) {
			response.sendError(HttpStatus.BAD_REQUEST.value(), "No existe ese Empleado >: (");
			return null;
		}
		
		Empleado empleado = empleadoOptional.get();
		
		return empleado;
	}
	
	@PostMapping("/{id}/asignar/sueldo")
	@ResponseBody
	public Empleado asignarSueldo(@PathVariable Long id, @RequestParam Double sueldo,
			HttpServletResponse response) throws IOException {
		Empleado empleado = empleadoService.asignarSueldo(id, sueldo);
		
		if (empleado == null) {
			response.sendError(HttpStatus.BAD_REQUEST.value(), empleadoService.getLastMessage());
		}
		
		return empleado;
	}
	
	@GetMapping("/nomina")
	@ResponseBody
	public Double calcularNomina() {
		return empleadoRepository.sumaNomina();
	}
	
	@PutMapping("")
	@ResponseBody
	public Empleado crearEmpleado(@RequestParam String nombre) {
		Empleado empleado = new Empleado();
		empleado.setNombre(nombre);
		return empleadoService.crearEmpleado(empleado);
	}
	
	@GetMapping("")
	@ResponseBody
	public Iterable<Empleado> mostrarEmpleados() {
		return empleadoRepository.findAll();
	}
	
}
