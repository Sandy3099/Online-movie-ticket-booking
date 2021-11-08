package com.cg.sprint1.mvtktapp.sample.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cg.sprint1.mvtktapp.sample.entity.Theatre;
import com.cg.sprint1.mvtktapp.sample.service.TheatreService;

@RestController
@RequestMapping("/theatre")
public class TheatreController 
{
	@Autowired
	TheatreService theatreService;
	
	@GetMapping(produces="application/json")
	public ResponseEntity<List<Theatre>> getTheatresList()
	{
		return new ResponseEntity<List<Theatre>>(theatreService.getAllTheatre(),HttpStatus.OK);
	}
	
	@GetMapping(value="/{theatreId}",produces="application/json")
	public ResponseEntity<Theatre> getTheatreDetails(@PathVariable String theatreId)
	{
		Theatre t= theatreService.getByTheatre(theatreId);
		return  new ResponseEntity<Theatre>(t,HttpStatus.OK);
	}
	
	
	@ExceptionHandler(RuntimeException.class)
	public HttpStatus exceptionHandlerMethod()
	{
		return HttpStatus.NO_CONTENT;
	}
}
