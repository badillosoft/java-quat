package com.quat.api;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.quat.dao.EmpleadoDAO;
import com.quat.dao.ProyectoDAO;
import com.quat.dto.EmpleadoDTO;
import com.quat.dto.ProyectoDTO;
import com.quat.service.EmpleadoService;
import com.quat.service.ProyectoService;

@RestController
@RequestMapping("/api/proyecto")
public class ProyectoApiController {

	@Autowired
	ProyectoService proyectoService;

	@Autowired
	ProyectoDAO proyectoDao;

	@PutMapping("")
	public ProyectoDTO registrarProyecto(@ModelAttribute ProyectoDTO proyecto) {
		return proyectoService.crearProyecto(proyecto);
	}

	@PostMapping("/{id}/asignar/presupuesto")
	@ResponseBody
	public ProyectoDTO asignarPresupuesto(@PathVariable Long id, @PathVariable Double presupuesto) {
		ProyectoDTO proyecto = new ProyectoDTO();
		proyecto = proyectoService.buscarProyecto(id);
		if (proyecto != null) {
			proyecto = proyectoService.asignarPresupuesto(proyecto, presupuesto);
		} else {
			return null;
		}
		return proyecto;
	}

	@PostMapping("/{id}/asignar/fechafin")
	@ResponseBody
	public ProyectoDTO asignarFecha(@PathVariable Long id) {
		ProyectoDTO proyecto = new ProyectoDTO();
		proyecto = proyectoService.buscarProyecto(id);
		if (proyecto != null) {
			proyecto = proyectoService.asignarFechaFin(proyecto);
		} else {
			return null;
		}
		return proyecto;

	}

	@GetMapping("/proyectos")
	@ResponseBody
	public Iterable<ProyectoDTO> mostrarProyectos() {
		return proyectoDao.findAll();
	}
}
