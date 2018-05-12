package com.badillosoft.api;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.time.Instant;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.badillosoft.model.EmpleadoDTO;
import com.badillosoft.model.Media;
import com.badillosoft.repository.MediaRepository;
import com.badillosoft.service.EmpleadoService;
import com.badillosoft.service.MediaService;

@RestController
@RequestMapping("/api/media")
public class MediaApiController {

	@Autowired
	MediaService mediaService;
	
	@Autowired
	EmpleadoService empleadoService;
	
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
	
	@GetMapping("/{uuid}")
	public Optional<Media> getMedia(@PathVariable String uuid) {
		return mediaRepository.findByUuid(uuid);
	}
	
	@GetMapping("/{uuid}/download")
	public void downloadMedia(@PathVariable String uuid, HttpServletResponse response) throws IOException {
		Optional<Media> mediaOptional = mediaRepository.findByUuid(uuid);
		
		if (!mediaOptional.isPresent()) {
			response.sendError(400, "Invalid media");
			return;
		}
		
		Media media = mediaOptional.get();
		
		File file = new File(media.getPath());
		
		if(!file.exists()){
			response.sendError(400, "File does not exists");
			return;
        }
		
		response.setContentType(media.getType());
		response.setContentLengthLong(media.getSize());
		response.setHeader("Content-Disposition", String.format("inline; filename=\"" + file.getName() +"\""));
		
		InputStream inputStream = new BufferedInputStream(new FileInputStream(file));
		
		FileCopyUtils.copy(inputStream, response.getOutputStream());
	}
	
	public EmpleadoDTO rowToEmpleado(Row row) {
		
		
		EmpleadoDTO empleado = new EmpleadoDTO();
		
		empleado.setAdoNombre(row.getCell(1).getStringCellValue());
		empleado.setAdoApPaterno(row.getCell(2).getStringCellValue());
		empleado.setAdoApMaterno(row.getCell(3).getStringCellValue());
		empleado.setAdoDireccion(row.getCell(4).getStringCellValue());
		empleado.setAdoTelefono((long)row.getCell(5).getNumericCellValue());
		empleado.setAdoGenero(row.getCell(6).getStringCellValue());
		//empleado.setAdoFechaNacimiento(java.sql.Date.);
		empleado.setAdoCorreo(row.getCell(8).getStringCellValue());
		//empleado.setAdoFechaIngreso(java.sql.Date.valueOf(row.getCell(9).getDateCellValue().toString()));
		
		//empleado.setAdoTelefono(123l);
		empleado.setAdoFechaNacimiento(java.sql.Date.valueOf("1988-1-1"));
		empleado.setAdoFechaIngreso(java.sql.Date.valueOf("1988-1-1"));
		
		return empleado;
	}
	
	@GetMapping("/{uuid}/excel/cargar/empleado")
	public String cargarEmpleado(@PathVariable String uuid, HttpServletResponse response) throws IOException, InvalidFormatException {
		Optional<Media> mediaOptional = mediaRepository.findByUuid(uuid);
		
		if (!mediaOptional.isPresent()) {
			response.sendError(400, "Invalid media");
			return null;
		}
		
		Media media = mediaOptional.get();
		
		File file = new File(media.getPath());
		
		if(!file.exists()){
			response.sendError(400, "File does not exists");
			return null;
        }
		
		System.out.printf("MEDIA: Abriendo %s\n", file.getAbsolutePath());
		
		FileInputStream fin = new FileInputStream(new File(media.getPath()));
		
		Workbook workbook = new XSSFWorkbook(fin);
		
		Sheet sheet = workbook.getSheet("Empleado");
		
		if (sheet == null) {
			response.sendError(400, "Sheet does not exists");
			return null;
		}
		
		for (Row row : sheet) {
			if (row.getRowNum() == 0) {
				continue;
			}
			EmpleadoDTO empleado = rowToEmpleado(row);
			empleadoService.registrarEmpleado(empleado);
		}
		
		return "ok";
	}
	
	@GetMapping("/{uuid}/excel/{sheetName}")
	public String processMedia(@PathVariable String uuid, @PathVariable String sheetName, HttpServletResponse response) throws IOException, InvalidFormatException {
		Optional<Media> mediaOptional = mediaRepository.findByUuid(uuid);
		
		if (!mediaOptional.isPresent()) {
			response.sendError(400, "Invalid media");
			return null;
		}
		
		Media media = mediaOptional.get();
		
		File file = new File(media.getPath());
		
		if(!file.exists()){
			response.sendError(400, "File does not exists");
			return null;
        }
		
		System.out.printf("MEDIA: Abriendo %s\n", file.getAbsolutePath());
		
		FileInputStream fin = new FileInputStream(new File(media.getPath()));
		
		Workbook workbook = new XSSFWorkbook(fin);
		
		Sheet sheet = workbook.getSheet(sheetName);
		
		if (sheet == null) {
			response.sendError(400, "Sheet does not exists");
			return null;
		}
		
		String result = "";
		
		for (Row row : sheet) {
		    for (Cell cell : row) {
		        switch (cell.getCellType()) {
		        	case Cell.CELL_TYPE_NUMERIC:
			        	result += String.format("%f", cell.getNumericCellValue());
			        	break;
		        	case Cell.CELL_TYPE_STRING:
			        	result += String.format("%s", cell.getStringCellValue());
			        	break;
		        }
		        result += " ";
		    }
		    result += "<br>";
		}
		
		return result;
	}
	
}
