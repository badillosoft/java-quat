package com.quat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quat.model.Puesto;
import com.quat.reposity.PuestoRepository;

@Service
public class PuestoService {

	@Autowired
	PuestoRepository puestoRepository;
	
	public Puesto crearPuesto(Puesto puesto) {
		puestoRepository.save(puesto);
		return puesto;
	}
	
}
