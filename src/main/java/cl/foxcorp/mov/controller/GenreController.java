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

import cl.foxcorp.mov.entity.Genre;
import cl.foxcorp.mov.model.GenreModel;
import cl.foxcorp.mov.service.GenreService;
import cl.foxcorp.mov.util.ViewConstant;

@Controller
@RequestMapping("mov")
public class GenreController
{
	private static final Log log = LogFactory.getLog(GenreController.class);
	
	@Autowired
	@Qualifier("genreService")
	private GenreService genreService;
	
	@GetMapping("genres")
	public ResponseEntity<List<Genre>> getAllGenres()
	{
		List<Genre> list = genreService.getAllGenres();
		return new ResponseEntity<List<Genre>>(list, HttpStatus.OK);
	}
	
	@GetMapping("/showGenres")
	public ModelAndView showGenres() {
		ModelAndView mav = new ModelAndView(ViewConstant.TYPES);
		
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		mav.addObject("username", user.getUsername());
		mav.addObject("genres", genreService.listAllGenres());
		return mav;
	}
	
	@PostMapping("/addGenre")
	public String addGenre(@ModelAttribute(name="genreModel") GenreModel genreModel, Model model) {
		log.info("METHOD: addGenre() -- PARAMS: " + genreModel.toString());
		if ( null != genreService.addGenre(genreModel)) 
			model.addAttribute("result", 1);
		else
			model.addAttribute("result", 0);
		
		return "redirect:/mov/showGenres";		
	}
	
	@GetMapping("/removeGenre")
	public ModelAndView removeGenre(@RequestParam(name="id", required=true) int id) {
		genreService.removeGenre(id);
		return this.showGenres();		
	}
	
	@GetMapping("genreForm")
	public String redirectTypeForm(@RequestParam(name="id", required=false) int id, Model model) {
		GenreModel genre = new GenreModel();
		if ( id != 0 )
			genre = genreService.findGenreByIdModel(id);
		
		model.addAttribute("genreModel", genre);
		return ViewConstant.TYPE_FORM;
	}
	
	@GetMapping("/cancelGenre")
	public String cancel() {
		return "redirect:/mov/showGenres";
	}	
	
}
