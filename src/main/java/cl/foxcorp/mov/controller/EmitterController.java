package cl.foxcorp.mov.controller;

import java.util.List;

import org.springframework.security.core.userdetails.User;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import cl.foxcorp.mov.entity.Emitter;
import cl.foxcorp.mov.model.EmitterModel;
import cl.foxcorp.mov.service.EmitterService;
import cl.foxcorp.mov.util.ViewConstant;

@Controller
@RequestMapping("mov")
public class EmitterController 
{
	private static final Log log = LogFactory.getLog(EmitterController.class);
	
	@Autowired
	@Qualifier("emitterService")
	private EmitterService emitterService;
	
	@GetMapping("/emitters")
	public ResponseEntity<List<Emitter>> getAllSeries() {
		List<Emitter> list = emitterService.getAllEmitter();
		return new ResponseEntity<List<Emitter>>(list, HttpStatus.OK);
	}
	
	@GetMapping("/showEmitters")
	public ModelAndView showEmitters() {
		ModelAndView mav = new ModelAndView(ViewConstant.EMITTERS);
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		mav.addObject("username", user.getUsername());
		mav.addObject("emitters", emitterService.listAllEmitters());
		
		return mav;
	}
	
	@PostMapping("/addEmitter")
	public String addEmitter(@ModelAttribute(name="emitterModel") EmitterModel emitterModel, Model model) {
		log.info("METHOD: addEmitter() -- PARAMS: " + emitterModel.toString());
		if ( null != emitterService.addEmitter(emitterModel))
			model.addAttribute("result", 1);
		else
			model.addAttribute("result", 0);
		
		return "redirect:/mov/showEmitters";						
	}
	
	@GetMapping("/removeEmitter")
	public ModelAndView removeEmitter(@RequestParam(name="id", required=true) int id) {
		emitterService.removeEmitter(id);
		return this.showEmitters();
	}
	
	@GetMapping("/emitterForm")
	public String redirectEmitterForm(@RequestParam(name="id", required=false) int id, Model model) {
		EmitterModel emitterModel = new EmitterModel();
		if (id != 0)
			emitterModel = emitterService.findEmitterByIdModel(id);
		
		model.addAttribute("emitterModel", emitterModel);
		return ViewConstant.EMITTER_FORM;
	}
	
	@GetMapping("/cancelEmitter")
	public String cancel() {
		return "redirect:/mov/showEmitters";		
	}
 	
}
