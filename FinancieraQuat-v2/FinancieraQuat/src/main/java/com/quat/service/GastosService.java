package com.quat.service;

import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quat.dao.GastosDAO;
import com.quat.dto.GastosDTO;
import com.quat.dto.ProyectoDTO;



@Service
public class GastosService {

	
	@Autowired
	GastosDAO gastosDao;
	
	public GastosDTO registrarGasto(GastosDTO gasto) {
		gastosDao.save(gasto);
		return gasto;
	}
	
	public GastosDTO gastoProyecto(GastosDTO gasto, ProyectoDTO proyecto) {
		gasto.setTosProyecto(proyecto);
		gastosDao.save(gasto);
		return gasto;
	}

}
