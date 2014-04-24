package br.com.brasil.ct.service;

import java.io.File;

public interface StationsService {

	void importFrom(File cvs);
	
	void clean();

}
