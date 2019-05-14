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
	
	@Override
	public void addSerie(Serie serie)
	{
		em.persist(serie);
	}
	
	@Override
	public boolean serieExists(int id) 
	{
		String hql = "FROM Serie as ser WHERE ser.id = :id";
		int count = em.createQuery(hql).setParameter("id", id).getResultList().size();
		return count > 0 ? true : false;
	}
	
	@Override
	public void updateSerie(Serie serie) 
	{
		Serie ser = getSerieById(serie.getId());
		ser.setName(serie.getName());
		ser.setEmitter(serie.getEmitter());
		ser.setType(serie.getType());
		ser.setSeasons(serie.getSeasons());
		ser.setState(serie.getState());
		ser.setFrom(serie.getFrom());
		ser.setTo(serie.getTo());
		
		em.flush();		
	}
	
	@Override
	public Serie getSerieById(int id) 
	{
		return em.find(Serie.class, id);
	}	

}
