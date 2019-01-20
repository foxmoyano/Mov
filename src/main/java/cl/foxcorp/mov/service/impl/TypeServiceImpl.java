package cl.foxcorp.mov.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.foxcorp.mov.entity.Type;
import cl.foxcorp.mov.repository.TypeRepository;
import cl.foxcorp.mov.service.TypeService;

@Service
public class TypeServiceImpl implements TypeService
{
	@Autowired
	private TypeRepository typeRepository;

	@Override
	public List<Type> getAllTypes() 
	{
		return typeRepository.getAllTypes();
	}

}
