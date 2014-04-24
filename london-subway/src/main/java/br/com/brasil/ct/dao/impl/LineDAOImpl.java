package br.com.brasil.ct.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.com.brasil.ct.dao.LineDAO;
import br.com.brasil.ct.model.Lines;

@Repository
public class LineDAOImpl implements LineDAO {

	@PersistenceContext
	private EntityManager em;

	public void setEntityManager(EntityManager em) {
		this.em = em;
	}

	@Override
	public void save(List<Lines> listLine) {
		for (Lines lines : listLine) {
			em.persist(lines);
		}

	}

	@Override
	public void clean() {
		em.createQuery("delete from Lines").executeUpdate();

	}

}
