package cl.foxcorp.mov.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.foxcorp.mov.entity.Emitter;
import cl.foxcorp.mov.repository.EmitterRepository;
import cl.foxcorp.mov.service.EmitterService;

@Service
public class EmitterServiceImpl implements EmitterService 
{
	@Autowired
	private EmitterRepository emitterRepository;
	
	@Override
	public List<Emitter> getAllEmitter() 
	{
		return emitterRepository.getAllEmitter();
	}

}
