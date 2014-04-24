package br.com.brasil.ct.service;

import br.com.brasil.ct.model.FileImport;

public interface ImportDataService {
	
	void loadFromCsv(FileImport fileImport);
	
	void clean();

}
