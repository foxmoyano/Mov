package cl.foxcorp.mov.component;

import org.springframework.stereotype.Component;

import cl.foxcorp.mov.entity.Emitter;
import cl.foxcorp.mov.entity.Genre;
import cl.foxcorp.mov.entity.Parameter;
import cl.foxcorp.mov.entity.Serie;
import cl.foxcorp.mov.model.SerieModel;
import cl.foxcorp.mov.model.TuplaModel;

@Component("serieConverter")
public class SerieConverter {

	public Serie converterSerieModel2Serie(SerieModel serieModel) {
		Serie serie = new Serie();
		serie.setId(serieModel.getId());
		serie.setName(serieModel.getName());
		serie.setEpisodes(serieModel.getEpisodes());
		serie.setSeasons(serieModel.getSeasons());
		serie.setCreated(serieModel.getCreated());
		serie.setOrigin(serieModel.getOrigin());		
		Emitter emitter = new Emitter();
		emitter.setId(serieModel.getEmitter().getCodigo());
		serie.setEmitter(emitter);		
		serie.setFrom(serieModel.getYearFrom());
		serie.setTo(serieModel.getYearTo());				
		Parameter state = new Parameter();
		state.setId(serieModel.getState().getCodigo());
		serie.setState(state);		
		Genre genre = new Genre();		
		genre.setId(serieModel.getGenre().getCodigo());
		serie.setGenre(genre);
		
		return serie;
	}
	
	public SerieModel converterSerie2SerieModel(Serie serie) {
		SerieModel serieModel = new SerieModel();
		serieModel.setId(serie.getId());
		serieModel.setName(serie.getName());
		serieModel.setEpisodes(serie.getEpisodes());
		serieModel.setSeasons(serie.getSeasons());
		serieModel.setCreated(serie.getCreated());
		serieModel.setOrigin(serie.getOrigin());						
		TuplaModel emitter = new TuplaModel();
		emitter.setCodigo(serie.getEmitter().getId());
		emitter.setDescripcion(serie.getEmitter().getName());
		serieModel.setEmitter(emitter);
		serieModel.setYearFrom(serie.getFrom());
		serieModel.setYearTo(serie.getTo());
		TuplaModel state = new TuplaModel();
		state.setCodigo(serie.getState().getId());
		state.setDescripcion(serie.getState().getDescription());
		serieModel.setState(state);		
		TuplaModel genre = new TuplaModel();
		genre.setCodigo(serie.getGenre().getId());
		genre.setDescripcion(serie.getGenre().getName());		
		serieModel.setGenre(genre);
				
		return serieModel;
	}
}
