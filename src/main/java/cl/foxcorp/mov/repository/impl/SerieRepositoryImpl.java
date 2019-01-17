package cl.foxcorp.mov.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;
import cl.foxcorp.mov.entity.Serie;
import cl.foxcorp.mov.repository.SerieRepository;

@Transactional
@Repository
public class SerieRepositoryImpl implements SerieRepository 
{
	@PersistenceContext
	private EntityManager em;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Serie> getAllSeries() 
	{
		String hql = "FROM Serie as ser";
		return (List<Serie>) em.createQuery(hql).getResultList();
	}

}
