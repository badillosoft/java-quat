package com.quat.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quat.dao.GastosDAO;
import com.quat.dto.GastosDTO;
import com.quat.service.GastosService;

@RestController
@RequestMapping("/api/gastos")
public class GastosApiController {

	@Autowired
	GastosService gastosService;
	
	@Autowired
	GastosDTO gastosDto;

	@Autowired
	GastosDAO gastosDao;

	@PutMapping("")
	public GastosDTO registrarEmpleado(@ModelAttribute GastosDTO gasto) {
		return gastosService.registrarGasto(gasto);
	}

}
