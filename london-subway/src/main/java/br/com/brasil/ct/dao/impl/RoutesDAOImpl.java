package br.com.brasil.ct.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.com.brasil.ct.dao.RoutesDAO;
import br.com.brasil.ct.model.Routes;

@Repository
public class RoutesDAOImpl implements RoutesDAO {
	
	@PersistenceContext
	private EntityManager em;
	
	public void setEntityManager(EntityManager em) {
        this.em = em;
    }

	@Override
	public void save(List<Routes> listRoutes) {
		for (Routes routes : listRoutes) {
			em.persist(routes);	
		}
		

	}

	@Override
	public void clean() {
		em.createQuery("delete from Routes").executeUpdate();
		
	}

}
