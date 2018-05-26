package com.quat.service;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.quat.dto.MediaDTO;
import com.quat.dao.MediaDAO;

@Service
public class MediaService {
	
	public final String TEMP_DIR = "/app/files";
	
	@Autowired
	MediaDAO mediaDAO;

	public MediaDTO saveFile(MultipartFile file) throws IOException {
		
		String uuid = UUID.randomUUID().toString();
		
		String randomName = String.format("%s--%s", uuid, file.getOriginalFilename());
		
		String filename = String.format("%s/%s", TEMP_DIR, randomName); 
		
		file.transferTo(new File(filename));
		
		MediaDTO media = new MediaDTO();
		
		media.setDiaPath(filename);
		media.setDiaUuid(uuid);
		media.setDiaFilename(file.getOriginalFilename());
		media.setDiaSize(file.getSize());
		media.setDiaUploadAt(Timestamp.valueOf(LocalDateTime.now()));
		media.setDiaType(file.getContentType());
		String[] parts = file.getOriginalFilename().split("\\.");
		media.setDiaExtension(parts[parts.length - 1].toLowerCase());
		
		mediaDAO.save(media);
		
		return media;
	}
	
}
