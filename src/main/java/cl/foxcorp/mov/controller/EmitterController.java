package cl.foxcorp.mov.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import cl.foxcorp.mov.entity.Emitter;
import cl.foxcorp.mov.service.EmitterService;

@Controller
@RequestMapping("mov")
public class EmitterController 
{
	@Autowired
	private EmitterService emitterService;
	
	@GetMapping("emitters")
	public ResponseEntity<List<Emitter>> getAllSeries() 
	{
		List<Emitter> list = emitterService.getAllEmitter();
		return new ResponseEntity<List<Emitter>>(list, HttpStatus.OK);
	}		
}
