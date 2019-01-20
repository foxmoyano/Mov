package cl.foxcorp.mov.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import cl.foxcorp.mov.entity.Type;
import cl.foxcorp.mov.repository.TypeRepository;

@Transactional
@Repository
public class TypeRepositoryImpl implements TypeRepository 
{
	@PersistenceContext
	private EntityManager em;

	@SuppressWarnings("unchecked")
	@Override
	public List<Type> getAllTypes() 
	{
		String hql = "FROM Type as typ";
		return (List<Type>) em.createQuery(hql).getResultList();	
	}
	
}
