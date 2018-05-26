package com.quat.dto;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class MediaDTO {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	Long diaId;
	
	@Column(length=1024)
	String diaPath;
	
	String diaUuid;
	
	String diaFilename;
	
	String diaExtension;
	
	String diaType;
	
	Timestamp diaUploadAt;
	
	Long diaSize;

	public Long getDiaId() {
		return diaId;
	}

	public void setDiaId(Long diaId) {
		this.diaId = diaId;
	}

	public String getDiaPath() {
		return diaPath;
	}

	public void setDiaPath(String diaPath) {
		this.diaPath = diaPath;
	}

	public String getDiaUuid() {
		return diaUuid;
	}

	public void setDiaUuid(String diaUuid) {
		this.diaUuid = diaUuid;
	}

	public String getDiaFilename() {
		return diaFilename;
	}

	public void setDiaFilename(String diaFilename) {
		this.diaFilename = diaFilename;
	}

	public String getDiaExtension() {
		return diaExtension;
	}

	public void setDiaExtension(String diaExtension) {
		this.diaExtension = diaExtension;
	}

	public String getDiaType() {
		return diaType;
	}

	public void setDiaType(String diaType) {
		this.diaType = diaType;
	}

	public Timestamp getDiaUploadAt() {
		return diaUploadAt;
	}

	public void setDiaUploadAt(Timestamp diaUploadAt) {
		this.diaUploadAt = diaUploadAt;
	}

	public Long getDiaSize() {
		return diaSize;
	}

	public void setDiaSize(Long diaSize) {
		this.diaSize = diaSize;
	}
	
}
