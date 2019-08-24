package cl.foxcorp.mov.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import cl.foxcorp.mov.component.SerieConverter;
import cl.foxcorp.mov.entity.Serie;
import cl.foxcorp.mov.model.SerieModel;
import cl.foxcorp.mov.repository.SerieRepository;
import cl.foxcorp.mov.service.SerieService;

@Service("serieService")
public class SerieServiceImpl implements SerieService 
{
	@Autowired
	@Qualifier("serieRepository")
	private SerieRepository serieRepository;
	
	@Autowired
	@Qualifier("serieConverter")
	private SerieConverter serieConverter;
	
	@Override
	public List<Serie> getAllSeries() 
	{
		return serieRepository.findAll();
	}
	
//	@Override
//	public boolean addSerie(Serie serie) 
//	{
//		if (serieRepository.serieExists(serie.getId())) 
//		{
//			return false;
//		} 
//		else 
//		{
//			serieRepository.addSerie(serie);
//			return true;
//		}		
//	}
//	
//	@Override
//	public void updateSerie(Serie serie) 
//	{
//		serieRepository.updateSerie(serie);		
//	}

	@Override
	public List<SerieModel> listAllSeries() {
		List<Serie> series = serieRepository.findAll();
		List<SerieModel> lstSerieModel = new ArrayList<SerieModel>();
		for(Serie serie : series)
			lstSerieModel.add( serieConverter.converterSerie2SerieModel(serie) );
		
		return lstSerieModel;		
	}

	@Override
	public SerieModel addSerie(SerieModel serieModel) {
		Serie serie = serieRepository.save( serieConverter.converterSerieModel2Serie(serieModel) );
		return serieConverter.converterSerie2SerieModel(serie);
	}

	@Override
	public Serie findSerieById(int id) {
		return serieRepository.findSerieById(id);
	}

	@Override
	public void removeSerie(int id) {
		Serie serie = serieRepository.findSerieById(id);
		if ( null != serie)
			serieRepository.delete(serie);
	}

	@Override
	public SerieModel findSerieByIdModel(int id) {
		return serieConverter.converterSerie2SerieModel( this.findSerieById(id) );
	}	

}
