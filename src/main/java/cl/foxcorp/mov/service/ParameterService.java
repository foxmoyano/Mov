package cl.foxcorp.mov.service;

import java.util.List;

import cl.foxcorp.mov.entity.Parameter;
import cl.foxcorp.mov.model.ParameterModel;

public interface ParameterService {
	public List<Parameter> listAllParameters(String param);
	public List<ParameterModel> listParameters(String parameter);
}
