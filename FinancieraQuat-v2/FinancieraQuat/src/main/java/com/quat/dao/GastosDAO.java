package com.quat.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.quat.dto.GastosDTO;

@Transactional
public interface GastosDAO extends CrudRepository<GastosDTO, Long>{

}
