package com.badillosoft.service;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.badillosoft.model.Media;
import com.badillosoft.repository.MediaRepository;

@Service
public class MediaService {
	
	@Autowired
	MediaRepository mediaRepository;

	public Media saveFile(MultipartFile file) throws IOException {
		
		String uuid = UUID.randomUUID().toString();
		
		String randomName = String.format("%s--%s", uuid, file.getOriginalFilename());
		
		String filename = String.format("/quat/files/%s", randomName); 
		
		file.getSize();
		
		file.transferTo(new File(filename));
		
		Media media = new Media();
		
		media.setPath(filename);
		media.setUuid(uuid);
		media.setFilename(file.getOriginalFilename());
		media.setSize(file.getSize());
		media.setUploadAt(Timestamp.valueOf(LocalDateTime.now()));
		media.setType(file.getContentType());
		String[] parts = file.getOriginalFilename().split("\\.");
		media.setExtension(parts[parts.length - 1].toLowerCase());
		
		mediaRepository.save(media);
		
		return media;
	}
	
}
