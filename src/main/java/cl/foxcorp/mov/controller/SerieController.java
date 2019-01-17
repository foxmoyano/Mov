package cl.foxcorp.mov.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import cl.foxcorp.mov.entity.Serie;
import cl.foxcorp.mov.service.SerieService;

@Controller
@RequestMapping("tinApp")
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
}
