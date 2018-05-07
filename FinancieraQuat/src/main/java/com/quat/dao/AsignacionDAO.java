package com.quat.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.quat.dto.AsignacionDTO;

@Transactional
public interface AsignacionDAO extends CrudRepository<AsignacionDTO, Long>{

}
