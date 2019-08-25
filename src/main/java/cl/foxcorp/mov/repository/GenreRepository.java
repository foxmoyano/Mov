package cl.foxcorp.mov.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cl.foxcorp.mov.entity.Genre;

@Repository("genreRepository")
public interface GenreRepository extends JpaRepository<Genre, Serializable> {
	
	public abstract Genre findGenreById(int id);
	
}
