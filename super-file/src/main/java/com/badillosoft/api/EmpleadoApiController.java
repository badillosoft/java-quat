package com.badillosoft.api;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.badillosoft.repository.EmpleadoDAO;
import com.badillosoft.model.EmpleadoDTO;
import com.badillosoft.service.EmpleadoService;

@RestController
@RequestMapping("/api/empleado")
public class EmpleadoApiController {

	@Autowired
	EmpleadoService empleadoService;

	@Autowired
	EmpleadoDAO empleadoDao;

	@PutMapping("")
	/*
	 * Este seria el caso de no contar con @ModelAttribute public EmpleadoDTO
	 * registrarEmpleado(@RequestParam String adoNombre,
	 * 
	 * @RequestParam String adoApPaterno,
	 * 
	 * @RequestParam String adoApMaterno,
	 * 
	 * @RequestParam String adoDireccion,
	 * 
	 * @RequestParam Long adoTelefono,
	 * 
	 * @RequestParam String adoGenero,
	 * 
	 * @RequestParam Date adoFechaNacimiento,
	 * 
	 * @RequestParam String adoCorreo,
	 * 
	 * @RequestParam Date adoFechaIngreso) {
	 * 
	 * EmpleadoDTO empleado = new EmpleadoDTO();
	 * 
	 * empleado.setAdoNombre(adoNombre); empleado.setAdoApPaterno(adoApPaterno);
	 * empleado.setAdoApMaterno(adoApMaterno);
	 * empleado.setAdoDireccion(adoDireccion); empleado.setAdoTelefono(adoTelefono);
	 * empleado.setAdoGenero(adoGenero);
	 * empleado.setAdoFechaNacimiento(adoFechaNacimiento);
	 * empleado.setAdoCorreo(adoCorreo);
	 * empleado.setAdoFechaIngreso(adoFechaIngreso); return
	 * empleadoService.registrarEmpleado(empleado);
	 * 
	 * }
	 */
	public EmpleadoDTO registrarEmpleado(@ModelAttribute EmpleadoDTO empleado) {
		return empleadoService.registrarEmpleado(empleado);
	}

	// Asignar una nomina mediante el id del empleado
	@PostMapping("/{id}/asignar/nomina")
	@ResponseBody
	public EmpleadoDTO asignarNomina(@PathVariable Long id, @PathVariable String tipoNomina) {
		EmpleadoDTO empleado = new EmpleadoDTO();
		try {
			empleado = empleadoService.buscarEmpleado(id);
			if (empleado != null) {
				empleado = empleadoService.asignarNomina(empleado, tipoNomina);
			} else {
				return null;
			}
		} catch (Exception e) {
			e.getMessage();
			return null;
		}
		return empleado;
	}

	// Asignar una Puesto mediante el id del empleado
	@PostMapping("/{id}/asignar/puesto")
	@ResponseBody
	public EmpleadoDTO asignarPuesto(@PathVariable Long id, @PathVariable String puesto) {
		EmpleadoDTO empleado = new EmpleadoDTO();
		try {
			empleado = empleadoService.buscarEmpleado(id);
			if (empleado != null) {
				empleado = empleadoService.asignarPuesto(empleado, puesto);
			} else {
				return null;
			}
		} catch (Exception e) {
			e.getMessage();
			return null;
		}
		return empleado;
	}

	// Asignar una Puesto mediante el id del empleado
	@PostMapping("/{id}/asignar/sueldo")
	@ResponseBody
	public EmpleadoDTO asignarSueldo(@PathVariable Long id, @PathVariable Double sueldo) {
		EmpleadoDTO empleado = new EmpleadoDTO();
		try {
			empleado = empleadoService.buscarEmpleado(id);
			if (empleado != null) {
				empleado = empleadoService.asignarSueldo(empleado, sueldo);
			} else {
				return null;
			}
		} catch (Exception e) {
			e.getMessage();
			return null;
		}
		return empleado;
	}

	@GetMapping("/nomina")
	@ResponseBody
	public Double calcularNomina() {
		return empleadoDao.sumaNomina();
	}

	@GetMapping("/empleados")
	@ResponseBody
	public Iterable<EmpleadoDTO> mostrarEmpleados() {
		return empleadoDao.findAll();
	}

	@GetMapping("/baja/empleado")
	@ResponseBody
	public void bajaEmpleado(@PathVariable Long idEmpleado) {

		//
	}

}
