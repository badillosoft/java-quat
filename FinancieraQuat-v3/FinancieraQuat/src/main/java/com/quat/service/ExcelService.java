package com.quat.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Date;
import java.util.Optional;

import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quat.dao.EmpleadoDAO;
import com.quat.dao.MediaDAO;
import com.quat.dto.EmpleadoDTO;
import com.quat.dto.MediaDTO;

@Service
public class ExcelService {
	
	public final String TEMP_EXCEL = "/app/sys/temp.xlsx";
	
	public final String EMPLEADO_SHEETNAME = "Empleado";
	public final String PROYECTO_SHEETNAME = "Proyecto";
	public final String GASTOS_SHEETNAME = "Gastos";
	public final String ASIGNACION_SHEETNAME = "Asignacion";

	@Autowired
	EmpleadoService empleadoService;
	
	@Autowired
	MediaDAO mediaDAO;
	
	@Autowired
	EmpleadoDAO empleadoDAO;
	
	public Sheet openSheet(String filename, String sheetName) throws Exception {
		File file = new File(filename);
		
		if(!file.exists()){
			throw new Exception(String.format("No se puede abrir el archivo: %s", filename));
        }
		
		//System.out.printf("MEDIA: Abriendo %s\n", file.getAbsolutePath());
		
		FileInputStream fin = new FileInputStream(file);
		
		Workbook workbook = new XSSFWorkbook(fin);
		
		Sheet sheet = workbook.getSheet(sheetName);
		
		if (sheet == null) {
			throw new Exception(String.format("No exite la hoja: %s", sheetName));
		}
		
		return sheet;
	}
	
	public void loadEmpleado(String uuid) throws Exception {
		Optional<MediaDTO> mediaOptional = mediaDAO.findByDiaUuid(uuid);
		
		if (!mediaOptional.isPresent()) {
			throw new Exception(String.format("No existe el media: %s", uuid));
		}
		
		MediaDTO media = mediaOptional.get();
		
		Sheet sheet = openSheet(media.getDiaPath(), EMPLEADO_SHEETNAME);
		
		for (Row row : sheet) {
			if (row.getRowNum() == 0) {
				continue;
			}
			
			EmpleadoDTO empleado = rowToEmpleado(row);
			
			if (empleado == null) {
				continue;
			}
			
			empleadoService.registrarEmpleado(empleado);
		}
		
	}
	
	public void empleadosToSheet(Sheet sheet, CellStyle cellDateStyle) {
		Iterable<EmpleadoDTO> empleados = empleadoDAO.findAll();
		
		Row rowHeaders = sheet.createRow(0);
		
		String[] headers = new String[] { "Id", "Nombre", "Apellido Paterno", "Apellido Materno", 
				"Direccion", "Telefono", "Genero", "Fecha de Nacimiento", "Correo", "Fecha de ingreso" };
		
		for (int j = 0; j < headers.length; j++) {
			Cell headerCell = rowHeaders.createCell(j);
			headerCell.setCellValue(headers[j]);
		}
		
		int i = 1;
		for (EmpleadoDTO empleado : empleados) {
			Row row = sheet.createRow(i++);
			
			row.createCell(0).setCellValue(empleado.getAdoId());
			row.createCell(1).setCellValue(empleado.getAdoNombre());
			row.createCell(2).setCellValue(empleado.getAdoApPaterno());
			row.createCell(3).setCellValue(empleado.getAdoApMaterno());
			row.createCell(4).setCellValue(empleado.getAdoDireccion());
			row.createCell(5).setCellValue(empleado.getAdoTelefono());
			row.createCell(6).setCellValue(empleado.getAdoGenero());
			Cell fechaNacCell = row.createCell(7);
			fechaNacCell.setCellStyle(cellDateStyle);
			fechaNacCell.setCellValue(new java.util.Date(empleado.getAdoFechaNacimiento().getTime()));
			row.createCell(8).setCellValue(empleado.getAdoCorreo());
			Cell fechaIngCell = row.createCell(9);
			fechaIngCell.setCellStyle(cellDateStyle);
			fechaIngCell.setCellValue(new java.util.Date(empleado.getAdoFechaIngreso().getTime()));
		}
	}
	
	public String dbToExcel() throws IOException {
		Workbook workbook = new XSSFWorkbook();
		 
		Sheet sheet = workbook.createSheet(EMPLEADO_SHEETNAME);
		
		CellStyle cellDateStyle = workbook.createCellStyle();
		CreationHelper createHelper = workbook.getCreationHelper();
		cellDateStyle.setDataFormat(createHelper.createDataFormat().getFormat("dd/mm/yyyy"));
		
		empleadosToSheet(sheet, cellDateStyle);
		
		File currDir = new File(TEMP_EXCEL);
		 
		FileOutputStream outputStream = new FileOutputStream(currDir);
		
		workbook.write(outputStream);
		
		return TEMP_EXCEL;
	}
	
	public Date getDate(Cell cell) {
		if (HSSFDateUtil.isCellDateFormatted(cell)) {
	        return new Date(cell.getDateCellValue().getTime());
	    }
		
		Double value = cell.getNumericCellValue();
		Long tmpLong = (long)value.doubleValue();
		Date tmpDate = new Date(tmpLong);
		return tmpDate;
	}
	
	public EmpleadoDTO rowToEmpleado(Row row) {
		if (row.getCell(1).getStringCellValue().isEmpty() || row.getCell(1).getCellType() == Cell.CELL_TYPE_BLANK) {
			return null;
		}
		
		EmpleadoDTO empleado = new EmpleadoDTO();
		
		if (row.getCell(0).getCellType() == Cell.CELL_TYPE_NUMERIC) {
			Long id = (long)row.getCell(0).getNumericCellValue();
			empleado.setAdoId(id);
		}
		
		empleado.setAdoNombre(row.getCell(1).getStringCellValue());
		empleado.setAdoApPaterno(row.getCell(2).getStringCellValue());
		empleado.setAdoApMaterno(row.getCell(3).getStringCellValue());
		empleado.setAdoDireccion(row.getCell(4).getStringCellValue());
		empleado.setAdoTelefono((long)row.getCell(5).getNumericCellValue());
		empleado.setAdoGenero(row.getCell(6).getStringCellValue());
		empleado.setAdoFechaNacimiento(getDate(row.getCell(7)));
		empleado.setAdoCorreo(row.getCell(8).getStringCellValue());
		empleado.setAdoFechaIngreso(getDate(row.getCell(9)));
				
		return empleado;
	}
	
}
