package br.com.brasil.ct.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.com.brasil.ct.dao.StationsDAO;
import br.com.brasil.ct.model.Stations;

@Repository
public class StationsDAOImpl implements StationsDAO {

	@PersistenceContext
	private EntityManager em;

	public void setEntityManager(EntityManager em) {
		this.em = em;
	}

	@Override
	public void save(List<Stations> listStations) {
		for (Stations stations : listStations) {
			em.persist(stations);
		}

	}

	@Override
	public void clean() {
		em.createQuery("delete from Stations").executeUpdate();
		
	}

}
