package cl.foxcorp.mov.repository;

import java.util.List;
import cl.foxcorp.mov.entity.Serie;

public interface SerieRepository 
{
	public List<Serie> getAllSeries();
	public void addSerie(Serie serie);
	public boolean serieExists(int id);
	public void updateSerie(Serie serie);
	public Serie getSerieById(int id);
	
}
