package com.quat.api;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.quat.dto.MediaDTO;
import com.quat.dao.MediaDAO;
import com.quat.service.EmpleadoService;
import com.quat.service.MediaService;

@RestController
@RequestMapping("/api/media")
public class MediaApiController {

	@Autowired
	MediaService mediaService;
	
	@Autowired
	EmpleadoService empleadoService;
	
	@Autowired
	MediaDAO mediaDAO;
	
	@GetMapping("")
	public Iterable<MediaDTO> all() {
		return mediaDAO.findAll();
	}
	
	@PostMapping("")
	public MediaDTO upload(@RequestParam MultipartFile file) throws IOException {
		return mediaService.saveFile(file);
	}
	
	@GetMapping("/{uuid}")
	public Optional<MediaDTO> getMedia(@PathVariable String uuid) {
		return mediaDAO.findByDiaUuid(uuid);
	}
	
	@GetMapping("/{uuid}/download")
	public void downloadMedia(@PathVariable String uuid, HttpServletResponse response) throws IOException {
		Optional<MediaDTO> mediaOptional = mediaDAO.findByDiaUuid(uuid);
		
		if (!mediaOptional.isPresent()) {
			response.sendError(400, "Invalid media");
			return;
		}
		
		MediaDTO media = mediaOptional.get();
		
		File file = new File(media.getDiaPath());
		
		if(!file.exists()){
			response.sendError(400, "File does not exists");
			return;
        }
		
		response.setContentType(media.getDiaType());
		response.setContentLengthLong(media.getDiaSize());
		response.setHeader("Content-Disposition", String.format("inline; filename=\"" + file.getName() +"\""));
		
		InputStream inputStream = new BufferedInputStream(new FileInputStream(file));
		
		FileCopyUtils.copy(inputStream, response.getOutputStream());
	}
	
}
