package br.com.brasil.ct.dao;

import java.util.List;

import br.com.brasil.ct.model.Stations;

public interface StationsDAO {

	void save(List<Stations> listStations);

	void clean();

}
