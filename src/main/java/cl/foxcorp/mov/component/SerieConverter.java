package cl.foxcorp.mov.component;

import org.springframework.stereotype.Component;

import cl.foxcorp.mov.entity.Serie;
import cl.foxcorp.mov.model.SerieModel;

@Component("serieConverter")
public class SerieConverter {

	public Serie converterSerieModel2Serie(SerieModel serieModel) {
		Serie serie = new Serie();
		serie.setId(serieModel.getId());
		serie.setName(serieModel.getName());
		serie.setEpisodes(serieModel.getEpisodes());
		
		return serie;
	}
	
	public SerieModel converterSerie2SerieModel(Serie serie) {
		SerieModel serieModel = new SerieModel();
		serieModel.setId(serie.getId());
		serieModel.setName(serie.getName());
		serieModel.setEpisodes(serie.getEpisodes());
				
		return serieModel;
	}
}
