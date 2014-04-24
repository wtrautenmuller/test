package br.com.brasil.ct.service;

import java.io.File;

public interface RoutesService {
	
	void importFrom(File cvs);
	
	void clean();

}
