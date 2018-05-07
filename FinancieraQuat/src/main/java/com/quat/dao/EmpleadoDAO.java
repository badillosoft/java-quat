package com.quat.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.quat.dto.EmpleadoDTO;

@Transactional
public interface EmpleadoDAO  extends CrudRepository<EmpleadoDTO, Long>{

}
