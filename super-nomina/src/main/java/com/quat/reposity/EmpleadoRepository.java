package com.quat.reposity;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.quat.model.Empleado;

@Transactional
public interface EmpleadoRepository extends CrudRepository<Empleado, Long> {

	@Query(value="SELECT SUM(E.sueldo) FROM empleado E", nativeQuery=true)
	public Double sumaNomina();
	
}
