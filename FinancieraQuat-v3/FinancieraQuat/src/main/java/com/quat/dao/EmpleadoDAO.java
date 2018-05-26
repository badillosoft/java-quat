package com.quat.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.quat.dto.EmpleadoDTO;

@Transactional
public interface EmpleadoDAO  extends CrudRepository<EmpleadoDTO, Long>{
	
	@Query(value="SELECT SUM(E.sueldo) FROM empleado E", nativeQuery=true)
	public Double sumaNomina();
}
