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

import cl.foxcorp.mov.entity.Type;
import cl.foxcorp.mov.model.TypeModel;
import cl.foxcorp.mov.service.TypeService;
import cl.foxcorp.mov.util.ViewConstant;

@Controller
@RequestMapping("mov")
public class TypeController
{
	private static final Log log = LogFactory.getLog(TypeController.class);
	
	@Autowired
	@Qualifier("typeService")
	private TypeService typeService;
	
	@GetMapping("types")
	public ResponseEntity<List<Type>> getAllTypes()
	{
		List<Type> list = typeService.getAllTypes();
		return new ResponseEntity<List<Type>>(list, HttpStatus.OK);
	}
	
	@GetMapping("/showTypes")
	public ModelAndView showTypes() {
		ModelAndView mav = new ModelAndView(ViewConstant.TYPES);
		
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		mav.addObject("username", user.getUsername());
		mav.addObject("types", typeService.listAllTypes());
		return mav;
	}
	
	@PostMapping("/addType")
	public String addType(@ModelAttribute(name="typeModel") TypeModel typeModel, Model model) {
		log.info("METHOD: addType() -- PARAMS: " + typeModel.toString());
		if ( null != typeService.addType(typeModel)) 
			model.addAttribute("result", 1);
		else
			model.addAttribute("result", 0);
		
		return "redirect:/mov/showTypes";		
	}
	
	@GetMapping("/removeType")
	public ModelAndView removeType(@RequestParam(name="id", required=true) int id) {
		typeService.removeType(id);
		return this.showTypes();		
	}
	
	@GetMapping("typeForm")
	public String redirectTypeForm(@RequestParam(name="id", required=false) int id, Model model) {
		TypeModel type = new TypeModel();
		if ( id != 0 )
			type = typeService.findTypeByIdModel(id);
		
		model.addAttribute("typeModel", type);
		return ViewConstant.TYPE_FORM;
	}
	
	@GetMapping("/cancelType")
	public String cancel() {
		return "redirect:/mov/showTypes";
	}	
	
}
