package cl.foxcorp.mov.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.util.UriComponentsBuilder;

import cl.foxcorp.mov.entity.Serie;
import cl.foxcorp.mov.service.SerieService;

@Controller
@RequestMapping("mov")
public class SerieController 
{
	@Autowired
	private SerieService serieService;
	
	@GetMapping("series")
	public ResponseEntity<List<Serie>> getAllSeries() 
	{
		List<Serie> list = serieService.getAllSeries();
		return new ResponseEntity<List<Serie>>(list, HttpStatus.OK);
	}
	
	@PostMapping("serie")
	public ResponseEntity<Void> addSerie(@RequestBody Serie serie, UriComponentsBuilder builder) 
	{
		boolean flag = serieService.addSerie(serie);
		if (flag == false) {
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/serie/{id}").buildAndExpand(serie.getId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	
	@PutMapping("serie")
	public ResponseEntity<Serie> updateSerie(@RequestBody Serie serie) 
	{
		serieService.updateSerie(serie);
		return new ResponseEntity<Serie>(serie, HttpStatus.OK);
	}	
}
