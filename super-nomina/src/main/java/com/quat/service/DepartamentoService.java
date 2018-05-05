package com.quat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quat.model.Departamento;
import com.quat.reposity.DepartamentoRepository;

@Service
public class DepartamentoService {

	@Autowired
	DepartamentoRepository departamentoRepository;
	
	public Departamento crearDepartamento(Departamento departamento) {
		departamentoRepository.save(departamento);
		return departamento;
	}
	
}
