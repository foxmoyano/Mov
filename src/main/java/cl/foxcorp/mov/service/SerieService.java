package cl.foxcorp.mov.service;

import java.util.List;
import cl.foxcorp.mov.entity.Serie;

public interface SerieService 
{
	public List<Serie> getAllSeries();
	public boolean addSerie(Serie serie);
	public void updateSerie(Serie serie);
}
