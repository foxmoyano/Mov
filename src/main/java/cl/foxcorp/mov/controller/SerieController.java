package cl.foxcorp.mov.controller;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import cl.foxcorp.mov.entity.Serie;
import cl.foxcorp.mov.model.SerieModel;
import cl.foxcorp.mov.service.SerieService;
import cl.foxcorp.mov.service.TypeService;
import cl.foxcorp.mov.util.ViewConstant;

@Controller
@RequestMapping("mov")
public class SerieController 
{
	private static final Log log = LogFactory.getLog(SerieController.class);
	
	@Autowired
	@Qualifier("serieService")
	private SerieService serieService;
	
	@Autowired
	@Qualifier("typeService")
	private TypeService typeService;
	
	@GetMapping("/series")
	public ResponseEntity<List<Serie>> getAllSeries() 
	{
		List<Serie> list = serieService.getAllSeries();
		return new ResponseEntity<List<Serie>>(list, HttpStatus.OK);
	}
	
	@GetMapping("/showSeries")
	public ModelAndView showSeries() {
		ModelAndView mav = new ModelAndView(ViewConstant.SERIES);
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		mav.addObject("username", user.getUsername());
		mav.addObject("series", serieService.listAllSeries());		
		
		return mav;
	}
	
	@PostMapping("/addSerie")
	public String addSerie(@ModelAttribute(name="serieModel") SerieModel serieModel, Model model) {
		log.info("METHOD: addSerie() -- PARAMS: " + serieModel.toString());
		if ( null != serieService.addSerie(serieModel))
			model.addAttribute("result", 1);
		else
			model.addAttribute("result", 0);
		
		return "redirect:/mov/showSeries";
	}
	
	@GetMapping("removeSerie")
	public ModelAndView removeSerie(@RequestParam(name="id", required=true) int id) {
		serieService.removeSerie(id);
		return this.showSeries();
	}
	
	@GetMapping("serieForm")
	public String redirectSerieForm(@RequestParam(name="id", required=true) int id, Model model) {
		SerieModel serieModel = new SerieModel();
		if (id != 0)
			serieModel = serieService.findSerieByIdModel(id);
		
		model.addAttribute("serieModel", serieModel);		
		model.addAttribute("types", typeService.listAllTypes());
		
		return ViewConstant.SERIE_FORM;		
	}
	
	@GetMapping("/cancelSerie")
	public String cancel() {
		return "redirect:/mov/showSeries";
	}
	
	/*@PostMapping("serie")
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
	}*/	
}
