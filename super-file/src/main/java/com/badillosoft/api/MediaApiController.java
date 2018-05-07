package com.badillosoft.api;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.badillosoft.model.Media;
import com.badillosoft.repository.MediaRepository;
import com.badillosoft.service.MediaService;

@RestController
@RequestMapping("/api/media")
public class MediaApiController {

	@Autowired
	MediaService mediaService;
	
	@Autowired
	MediaRepository mediaRepository;
	
	@GetMapping("")
	public Iterable<Media> all() {
		return mediaRepository.findAll();
	}
	
	@PostMapping("")
	public Media upload(@RequestParam MultipartFile file) throws IOException {
		return mediaService.saveFile(file);
	}
	
	
}
