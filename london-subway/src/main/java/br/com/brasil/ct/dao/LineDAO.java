package br.com.brasil.ct.dao;

import java.util.List;

import br.com.brasil.ct.model.Lines;

public interface LineDAO {

	void save(List<Lines> listLine);
	
	void clean();

}
