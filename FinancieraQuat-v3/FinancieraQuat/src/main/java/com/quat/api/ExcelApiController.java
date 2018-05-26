package com.quat.api;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.quat.service.ExcelService;

@RestController
@RequestMapping("/api/excel")
public class ExcelApiController {

	@Autowired
	ExcelService excelService;
	
	@GetMapping("/load/empleados")
	public String loadEmpleado(@RequestParam String uuid) {
		
		try {
			excelService.loadEmpleado(uuid);
		} catch(Exception e) {
			return e.getMessage();
		}
		
		return "Empleados cargados";
	}
	
	@GetMapping("/download")
	public void downloadDb(HttpServletResponse response) throws IOException {
		String filename = excelService.dbToExcel();
		
		File file = new File(filename);
		
		if(!file.exists()){
			response.sendError(400, "File does not exists");
			return;
        }
		
		response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
		response.setContentLengthLong(file.length());
		response.setHeader("Content-Disposition", String.format("inline; filename=\"" + "db.xlsx" +"\""));
		
		InputStream inputStream = new BufferedInputStream(new FileInputStream(file));
		
		FileCopyUtils.copy(inputStream, response.getOutputStream());
	}
	
}
