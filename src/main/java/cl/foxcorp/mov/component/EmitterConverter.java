package cl.foxcorp.mov.component;

import org.springframework.stereotype.Component;

import cl.foxcorp.mov.entity.Emitter;
import cl.foxcorp.mov.model.EmitterModel;

@Component("emitterConverter")
public class EmitterConverter {
	
	public Emitter converterEmitterModel2Emitter(EmitterModel emitterModel) {
		Emitter emitter = new Emitter();
		emitter.setId(emitterModel.getId());
		emitter.setName(emitterModel.getName());
		return emitter;
	}
	
	public EmitterModel converterEmitter2EmitterModel(Emitter emitter) {
		EmitterModel mitterModel = new EmitterModel();
		mitterModel.setId(emitter.getId());
		mitterModel.setName(emitter.getName());
		return mitterModel;		
	}
	
}
