package br.com.brasil.ct.model;

import java.io.File;

import lombok.Data;

@Data
public class FileImport {
	
	private File stationsFile;
	
	private File routesFile;
	
	private File linesFile;

}
