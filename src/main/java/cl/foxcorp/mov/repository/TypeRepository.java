package cl.foxcorp.mov.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cl.foxcorp.mov.entity.Type;

@Repository("typeRepository")
public interface TypeRepository extends JpaRepository<Type, Serializable> {
	
	public abstract Type findTypeById(int id);
	
}
