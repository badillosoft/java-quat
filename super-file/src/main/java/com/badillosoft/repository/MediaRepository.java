package com.badillosoft.repository;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import com.badillosoft.model.Media;

@Transactional
public interface MediaRepository extends CrudRepository<Media, Long> {

	public Optional<Media> findByUuid(String uuid);
	
}
