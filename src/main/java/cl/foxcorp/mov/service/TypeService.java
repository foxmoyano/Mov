package cl.foxcorp.mov.service;

import java.util.List;
import cl.foxcorp.mov.entity.Type;
import cl.foxcorp.mov.model.TypeModel;

public interface TypeService {
	
	public List<Type> getAllTypes();

	public abstract List<TypeModel> listAllTypes();

	public abstract TypeModel addType(TypeModel typeModel);

	public abstract Type findTypeById(int id);

	public abstract void removeType(int id);

	public TypeModel findTypeByIdModel(int id);
}
