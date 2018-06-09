package com.quat.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.quat.dao.EmpleadoDAO;
import com.quat.dto.EmpleadoDTO;
import com.quat.service.EmpleadoService;

@Controller
@RequestMapping("/home")
public class HomeWebController {

	@Autowired
	EmpleadoDAO empleadoDao;
	
	@GetMapping("")
	public String home(Model model) {
		Iterable<EmpleadoDTO> empleados = empleadoDao.findAll();
		
		model.addAttribute("empleados", empleados);
		
		model.addAttribute("empleadoNuevoForm", new EmpleadoDTO());
		
		return "home";
	}
	
}
