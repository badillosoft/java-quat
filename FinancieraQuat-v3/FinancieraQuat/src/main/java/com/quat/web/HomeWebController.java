package com.quat.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.quat.dao.EmpleadoDAO;
import com.quat.dao.MediaDAO;
import com.quat.dao.ProyectoDAO;
import com.quat.dto.EmpleadoDTO;
import com.quat.dto.MediaDTO;
import com.quat.dto.ProyectoDTO;
import com.quat.service.EmpleadoService;

@Controller
@RequestMapping("/home")
public class HomeWebController {

	@Autowired
	EmpleadoDAO empleadoDao;
	@Autowired
	ProyectoDAO proyectoDao;
	@Autowired
	MediaDAO mediaDao;
	
	@GetMapping("")
	public String home(Model model) {
		Iterable<EmpleadoDTO> empleados = empleadoDao.findAll();
		Iterable<ProyectoDTO> proyectos = proyectoDao.findAll();
		Iterable<MediaDTO> medias = mediaDao.findAll();
		
		model.addAttribute("empleados", empleados);
		model.addAttribute("proyectos", proyectos);
		model.addAttribute("medias", medias);
		
		model.addAttribute("empleadoNuevoForm", new EmpleadoDTO());
		model.addAttribute("proyectoNuevoForm", new ProyectoDTO());
		
		return "home";
	}
	
}
