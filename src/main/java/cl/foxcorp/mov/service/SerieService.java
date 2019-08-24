package cl.foxcorp.mov.service;

import java.util.List;

import cl.foxcorp.mov.entity.Serie;
import cl.foxcorp.mov.model.SerieModel;

public interface SerieService 
{
	public List<Serie> getAllSeries();
	/*public boolean addSerie(Serie serie);
	public void updateSerie(Serie serie);*/
	
	public abstract List<SerieModel> listAllSeries();

	public abstract SerieModel addSerie(SerieModel serieModel);

	public abstract Serie findSerieById(int id);

	public abstract void removeSerie(int id);

	public SerieModel findSerieByIdModel(int id);
	
}
