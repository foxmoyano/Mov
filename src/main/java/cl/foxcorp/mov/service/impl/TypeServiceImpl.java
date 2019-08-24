package cl.foxcorp.mov.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import cl.foxcorp.mov.component.TypeConverter;
import cl.foxcorp.mov.entity.Type;
import cl.foxcorp.mov.model.TypeModel;
import cl.foxcorp.mov.repository.TypeRepository;
import cl.foxcorp.mov.service.TypeService;

@Service("typeService")
public class TypeServiceImpl implements TypeService
{
	@Autowired
	@Qualifier("typeRepository")
	private TypeRepository typeRepository;
	
	@Autowired
	@Qualifier("typeConverter")
	private TypeConverter typeConverter;	
	
	@Override
	public List<Type> getAllTypes() {		
		return typeRepository.findAll();
	}

	@Override
	public List<TypeModel> listAllTypes() {
		List<Type> types = typeRepository.findAll();
		List<TypeModel> lstTypeModel = new ArrayList<TypeModel>();
		for(Type type : types)
			lstTypeModel.add( typeConverter.convertType2TypeModel(type));
		
		return lstTypeModel;
	}

	@Override
	public TypeModel addType(TypeModel typeModel) {
		Type type = typeRepository.save(typeConverter.converterTypeModel2Type(typeModel));
		return typeConverter.convertType2TypeModel(type);
	}

	@Override
	public Type findTypeById(int id) {
		return typeRepository.findTypeById(id);
	}

	@Override
	public void removeType(int id) {
		Type type = this.findTypeById(id);
		if ( null != type )
			typeRepository.delete(type);
	}	

	@Override
	public TypeModel findTypeByIdModel(int id) {
		return typeConverter.convertType2TypeModel(this.findTypeById(id));
	}

}
