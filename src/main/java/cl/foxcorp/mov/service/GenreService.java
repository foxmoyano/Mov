package cl.foxcorp.mov.service;

import java.util.List;
import cl.foxcorp.mov.entity.Genre;
import cl.foxcorp.mov.model.GenreModel;

public interface GenreService {
	
	public List<Genre> getAllGenres();
	public abstract List<GenreModel> listAllGenres();
	public abstract GenreModel addGenre(GenreModel genreModel);
	public abstract Genre findGenreById(int id);
	public abstract void removeGenre(int id);
	public GenreModel findGenreByIdModel(int id);
}
