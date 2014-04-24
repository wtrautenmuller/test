package br.com.brasil.ct.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.com.brasil.ct.dao.DataFileDAO;
import br.com.brasil.ct.model.DataFile;

@Repository
public class DataFileDAOImpl implements DataFileDAO {

	@PersistenceContext
	private EntityManager em;

	public void setEntityManager(EntityManager em) {
		this.em = em;
	}

	@Override
	public void save(DataFile dataFile) {
		em.persist(dataFile);

	}

	@Override
	public DataFile getBy(boolean status) {
		String sql = "select d from DataFile d where d.status = :status";
		Query q= em.createQuery(sql);
		q.setParameter("status", status);
		try{
			return (DataFile)q.getSingleResult();	
		}catch(NonUniqueResultException e){
			return (DataFile)q.getResultList().get(0);
		}catch (NoResultException e) {
			return null;
		}
		
		
	}

	@Override
	public void clean() {
		em.createQuery("delete from DataFile").executeUpdate();
		
	}
}
