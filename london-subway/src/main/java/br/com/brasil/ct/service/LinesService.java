package br.com.brasil.ct.service;

import java.io.File;

public interface LinesService {

	void importFrom(File cvs);
	
	void clean();
}
