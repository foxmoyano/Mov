package cl.foxcorp.mov.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cl.foxcorp.mov.entity.Serie;

@Repository("serieRepository")
public interface SerieRepository extends JpaRepository<Serie, Serializable>
{
	public abstract Serie findSerieById(int id);
	/*public List<Serie> getAllSeries();
	public void addSerie(Serie serie);
	public boolean serieExists(int id);
	public void updateSerie(Serie serie);
	public Serie getSerieById(int id);*/
}
