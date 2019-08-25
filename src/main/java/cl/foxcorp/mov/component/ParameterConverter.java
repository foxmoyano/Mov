package cl.foxcorp.mov.component;

import org.springframework.stereotype.Component;
import cl.foxcorp.mov.entity.Parameter;
import cl.foxcorp.mov.model.ParameterModel;

@Component("parameterConverter")
public class ParameterConverter {
	public Parameter converterParameterModel2Parameter(ParameterModel parameterModel) {
		Parameter parameter = new Parameter();
		parameter.setId(parameterModel.getId());
		parameter.setParam(parameterModel.getParam());
		parameter.setCode(parameterModel.getCode());		
		parameter.setDescription(parameterModel.getDescription());
		
		return parameter;
	}
	
	public ParameterModel converterParameter2ParameterModel(Parameter parameter) {
		ParameterModel parameterModel = new ParameterModel();
		parameterModel.setId(parameter.getId());
		parameterModel.setParam(parameter.getParam());
		parameterModel.setCode(parameter.getCode());
		parameterModel.setDescription(parameter.getDescription());
		
		return parameterModel;		
	}
}
