package cl.foxcorp.mov.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import cl.foxcorp.mov.component.EmitterConverter;
import cl.foxcorp.mov.entity.Emitter;
import cl.foxcorp.mov.model.EmitterModel;
import cl.foxcorp.mov.repository.EmitterRepository;
import cl.foxcorp.mov.service.EmitterService;

@Service("emitterService")
public class EmitterServiceImpl implements EmitterService 
{
	@Autowired
	@Qualifier("emitterRepository")
	private EmitterRepository emitterRepository;
	
	@Autowired
	@Qualifier("emitterConverter")
	private EmitterConverter emitterConverter;
	
	@Override
	public List<Emitter> getAllEmitter() {
		return emitterRepository.findAll();
	}

	@Override
	public List<EmitterModel> listAllEmitters() {
		List<Emitter> emitters = emitterRepository.findAll();
		List<EmitterModel> lstEmittersModel = new ArrayList<EmitterModel>();
		for(Emitter em : emitters)
			lstEmittersModel.add( emitterConverter.converterEmitter2EmitterModel(em) );
		
		return lstEmittersModel;
	}

	@Override
	public EmitterModel addEmitter(EmitterModel emitterModel) {
		Emitter emitter = emitterRepository.save( emitterConverter.converterEmitterModel2Emitter(emitterModel)  );
		return emitterConverter.converterEmitter2EmitterModel(emitter);
	}

	@Override
	public Emitter findEmitterById(int id) {
		return emitterRepository.findEmitterById(id);
	}

	@Override
	public void removeEmitter(int id) {
		Emitter emitter = this.findEmitterById(id);
		if ( null != emitter)
			emitterRepository.delete(emitter);		
	}

	@Override
	public EmitterModel findEmitterByIdModel(int id) {
		return emitterConverter.converterEmitter2EmitterModel( this.findEmitterById(id) );
	}

}
