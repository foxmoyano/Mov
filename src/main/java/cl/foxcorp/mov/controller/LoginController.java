package cl.foxcorp.mov.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import cl.foxcorp.mov.util.ViewConstant;

@Controller
@RequestMapping("mov")
public class LoginController {

	private static final Log log = LogFactory.getLog(LoginController.class);

	@GetMapping("/login")
	public String showLoginForm(Model model, @RequestParam(name = "error", required = false) String error,
			@RequestParam(name = "logout", required = false) String logout) {
		log.info("METHOD: showLoginForm() -- PARAMS: error=" + error + ", logout:" + logout);
		model.addAttribute("error", error);
		model.addAttribute("logout", logout);
		log.info("Returning to login view");
		return ViewConstant.LOGIN;
	}

	@GetMapping({ "/loginsuccess", "/" })
	public String loginCheck() {
		log.info("METHOD: loginCheck()");
		log.info("Returning to contacts view");
		return "redirect:/mov/showMenu";
	}
	
	@GetMapping("/showMenu")
	public ModelAndView showMenu() {
		ModelAndView mav = new ModelAndView(ViewConstant.MENU);		
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		mav.addObject("username", user.getUsername());		
		return mav;
	}
	
	public static void main(String[] args) {
		BCryptPasswordEncoder pe = new BCryptPasswordEncoder();
		System.out.println(pe.encode("admin"));
	}	

}
