package cl.foxcorp.mov.component;

import org.springframework.stereotype.Component;

import cl.foxcorp.mov.entity.Type;
import cl.foxcorp.mov.model.TypeModel;

@Component("typeConverter") 
public class TypeConverter {
	
	public Type converterTypeModel2Type(TypeModel typeModel) {		
		Type type = new Type();
		type.setId(typeModel.getId());
		type.setName(typeModel.getName());		
		return type;
	}

	public TypeModel convertType2TypeModel(Type type) {
		TypeModel typeModel = new TypeModel();		
		typeModel.setId(type.getId());
		typeModel.setName(type.getName());		
		return typeModel;		
	}	
	
}
