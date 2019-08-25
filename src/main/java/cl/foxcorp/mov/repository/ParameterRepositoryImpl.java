package cl.foxcorp.mov.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import cl.foxcorp.mov.entity.Parameter;

@Repository("parameterRepository")
public class ParameterRepositoryImpl implements ParameterRepository {
	
	@PersistenceContext
	private EntityManager em;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Parameter> listParameterssByParam(String param) {
		String hql = "FROM Parameter as param where param.param.param = :param";		
		return (List<Parameter>) em.createQuery(hql).setParameter("param", param).getResultList();
	}
}
