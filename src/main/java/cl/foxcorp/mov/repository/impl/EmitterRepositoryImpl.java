package cl.foxcorp.mov.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import cl.foxcorp.mov.entity.Emitter;
import cl.foxcorp.mov.repository.EmitterRepository;

@Transactional
@Repository
public class EmitterRepositoryImpl implements EmitterRepository 
{
	@PersistenceContext
	private EntityManager em;

	@SuppressWarnings("unchecked")
	@Override
	public List<Emitter> getAllEmitter() 
	{
		String hql = "FROM Emitter emi";
		return (List<Emitter>) em.createQuery(hql).getResultList();
	}

}
