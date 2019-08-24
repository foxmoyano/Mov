package cl.foxcorp.mov.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cl.foxcorp.mov.entity.Emitter;

@Repository("emitterRepository")
public interface EmitterRepository extends JpaRepository<Emitter, Serializable> 
{
	public abstract Emitter findEmitterById(int id);
}
