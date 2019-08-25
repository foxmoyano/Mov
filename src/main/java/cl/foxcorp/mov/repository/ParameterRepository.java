package cl.foxcorp.mov.repository;

import java.util.List;

import cl.foxcorp.mov.entity.Parameter;

public interface ParameterRepository {
	public List<Parameter> listParameterssByParam(String param);
}
