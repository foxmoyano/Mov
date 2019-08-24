package cl.foxcorp.mov.service;

import java.util.List;

import cl.foxcorp.mov.entity.Emitter;
import cl.foxcorp.mov.model.EmitterModel;

public interface EmitterService {
	
	public List<Emitter> getAllEmitter();

	public abstract List<EmitterModel> listAllEmitters();

	public abstract EmitterModel addEmitter(EmitterModel emitterModel);

	public abstract Emitter findEmitterById(int id);

	public abstract void removeEmitter(int id);

	public EmitterModel findEmitterByIdModel(int id);
}
