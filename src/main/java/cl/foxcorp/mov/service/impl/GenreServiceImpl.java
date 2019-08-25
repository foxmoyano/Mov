package cl.foxcorp.mov.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import cl.foxcorp.mov.component.GenreConverter;
import cl.foxcorp.mov.entity.Genre;
import cl.foxcorp.mov.model.GenreModel;
import cl.foxcorp.mov.repository.GenreRepository;
import cl.foxcorp.mov.service.GenreService;

@Service("genreService")
public class GenreServiceImpl implements GenreService
{
	@Autowired
	@Qualifier("genreRepository")
	private GenreRepository genreRepository;
	
	@Autowired
	@Qualifier("genreConverter")
	private GenreConverter genreConverter;	
	
	@Override
	public List<Genre> getAllGenres() {		
		return genreRepository.findAll();
	}

	@Override
	public List<GenreModel> listAllGenres() {
		List<Genre> genres = genreRepository.findAll();
		List<GenreModel> lstGenreModel = new ArrayList<GenreModel>();
		for(Genre genre : genres)
			lstGenreModel.add( genreConverter.convertGenre2GenreModel(genre));
		
		return lstGenreModel;
	}

	@Override
	public GenreModel addGenre(GenreModel genreModel) {
		Genre genre = genreRepository.save(genreConverter.converterGenreModel2Genre(genreModel));
		return genreConverter.convertGenre2GenreModel(genre);
	}

	@Override
	public Genre findGenreById(int id) {
		return genreRepository.findGenreById(id);
	}

	@Override
	public void removeGenre(int id) {
		Genre genre = this.findGenreById(id);
		if ( null != genre )
			genreRepository.delete(genre);
	}	

	@Override
	public GenreModel findGenreByIdModel(int id) {
		return genreConverter.convertGenre2GenreModel(this.findGenreById(id));
	}

}
