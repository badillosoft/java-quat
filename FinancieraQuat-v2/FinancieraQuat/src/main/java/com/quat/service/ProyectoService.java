package com.quat.service;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quat.dao.ProyectoDAO;
import com.quat.dto.ProyectoDTO;

@Service
public class ProyectoService {
	@Autowired
	ProyectoDAO proyectoDao;

	public ProyectoDTO crearProyecto(ProyectoDTO proyecto) {
		return proyectoDao.save(proyecto);
	}

	public ProyectoDTO buscarProyecto(Long id) {
		Optional<ProyectoDTO> proyectoOptional = proyectoDao.findById(id);
		if (!proyectoOptional.isPresent()) {
			return null;
		}
		ProyectoDTO proyecto = proyectoOptional.get();
		return proyecto;
	}

	public ProyectoDTO asignarPresupuesto(ProyectoDTO proyecto, Double presupuesto) {
		proyecto.setCtoPresupuesto(presupuesto);
		proyecto = proyectoDao.save(proyecto);
		return proyecto;
	}

	public ProyectoDTO asignarFechaFin(ProyectoDTO proyecto) {
		Date dateTime;
		Calendar dateCalendar = Calendar.getInstance();
		dateTime = (Date) dateCalendar.getTime();
		proyecto.setCtoFechaFin(dateTime);
		proyecto = proyectoDao.save(proyecto);
		return proyecto;
	}

}
