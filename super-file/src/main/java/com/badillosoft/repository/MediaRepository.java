package com.badillosoft.repository;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import com.badillosoft.model.Media;

@Transactional
public interface MediaRepository extends CrudRepository<Media, Long> {

}
