package cl.foxcorp.mov.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.foxcorp.mov.entity.Serie;
import cl.foxcorp.mov.repository.SerieRepository;
import cl.foxcorp.mov.service.SerieService;

@Service
public class SerieServiceImpl implements SerieService 
{
	@Autowired
	private SerieRepository serieRepository;
	
	@Override
	public List<Serie> getAllSeries() 
	{
		return serieRepository.getAllSeries();
	}
	
	@Override
	public boolean addSerie(Serie serie) 
	{
		if (serieRepository.serieExists(serie.getId())) 
		{
			return false;
		} 
		else 
		{
			serieRepository.addSerie(serie);
			return true;
		}		
	}
	
	@Override
	public void updateSerie(Serie serie) 
	{
		serieRepository.updateSerie(serie);		
	}	

}
