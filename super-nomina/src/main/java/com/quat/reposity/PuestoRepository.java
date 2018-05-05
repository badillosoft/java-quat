package com.quat.reposity;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import com.quat.model.Puesto;

@Transactional
public interface PuestoRepository extends CrudRepository<Puesto, Long> {

}
