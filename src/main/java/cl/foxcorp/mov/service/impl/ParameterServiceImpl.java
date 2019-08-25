package cl.foxcorp.mov.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import cl.foxcorp.mov.component.ParameterConverter;
import cl.foxcorp.mov.entity.Parameter;
import cl.foxcorp.mov.model.ParameterModel;
import cl.foxcorp.mov.repository.ParameterRepository;
import cl.foxcorp.mov.service.ParameterService;

@Service("parameterService")
public class ParameterServiceImpl implements ParameterService {
	
	@Autowired
	@Qualifier("parameterRepository")
	private ParameterRepository parameterRepository;
	
	@Autowired
	@Qualifier("parameterConverter")
	private ParameterConverter parameterConverter;	
	
	@Override
	public List<Parameter> listAllParameters(String param) {
		return parameterRepository.listParameterssByParam(param);
	}
	
	@Override
	public List<ParameterModel> listParameters(String parameter) {
		List<Parameter> parameters = parameterRepository.listParameterssByParam(parameter);
		List<ParameterModel> lstParametersModel = new ArrayList<ParameterModel>();
		for(Parameter param : parameters)
			lstParametersModel.add( parameterConverter.converterParameter2ParameterModel(param));
		
		return lstParametersModel;
	}	

}
