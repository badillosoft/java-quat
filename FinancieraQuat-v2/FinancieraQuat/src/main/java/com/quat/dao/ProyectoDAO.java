package com.quat.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.quat.dto.ProyectoDTO;

@Transactional
public interface ProyectoDAO extends CrudRepository<ProyectoDTO, Long>{

}
