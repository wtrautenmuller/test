package br.com.brasil.ct.dao;

import java.util.List;

import br.com.brasil.ct.model.Routes;

public interface RoutesDAO {
	
	void save(List<Routes> listRoutes);
	
	void clean();

}
