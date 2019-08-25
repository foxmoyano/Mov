package cl.foxcorp.mov.component;

import org.springframework.stereotype.Component;

import cl.foxcorp.mov.entity.Genre;
import cl.foxcorp.mov.model.GenreModel;

@Component("genreConverter") 
public class GenreConverter {
	
	public Genre converterGenreModel2Genre(GenreModel genreModel) {		
		Genre type = new Genre();
		type.setId(genreModel.getId());
		type.setName(genreModel.getName());		
		return type;
	}

	public GenreModel convertGenre2GenreModel(Genre genre) {
		GenreModel genreModel = new GenreModel();		
		genreModel.setId(genre.getId());
		genreModel.setName(genre.getName());		
		return genreModel;		
	}	
	
}
