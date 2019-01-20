package cl.foxcorp.mov.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import cl.foxcorp.mov.service.TypeService;
import cl.foxcorp.mov.entity.Type;

@Controller
@RequestMapping("mov")
public class TypeController
{
	@Autowired
	private TypeService typeService;
	
	@GetMapping("types")
	public ResponseEntity<List<Type>> getAllTypes()
	{
		List<Type> list = typeService.getAllTypes();
		return new ResponseEntity<List<Type>>(list, HttpStatus.OK);
	}
	
}
