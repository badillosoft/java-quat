package com.quat.dao;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import com.quat.dto.MediaDTO;

@Transactional
public interface MediaDAO extends CrudRepository<MediaDTO, Long> {

	public Optional<MediaDTO> findByDiaUuid(String diaUuid);
	
}
