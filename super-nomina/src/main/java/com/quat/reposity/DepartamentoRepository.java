package com.quat.reposity;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import com.quat.model.Departamento;

@Transactional
public interface DepartamentoRepository extends CrudRepository<Departamento, Long> {
	
}
