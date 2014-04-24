package br.com.brasil.ct.dao;

import br.com.brasil.ct.model.DataFile;

public interface DataFileDAO {

	void save(DataFile dataFile);
	
	DataFile getBy(boolean status);
	
	void clean();

}
