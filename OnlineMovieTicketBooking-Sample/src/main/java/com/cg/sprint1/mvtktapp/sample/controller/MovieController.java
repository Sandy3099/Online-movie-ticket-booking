package com.cg.sprint1.mvtktapp.sample.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.sprint1.mvtktapp.sample.entity.Movie;
import com.cg.sprint1.mvtktapp.sample.service.MovieService;

@RestController
@RequestMapping("/movie")
public class MovieController 
{
	@Autowired
	MovieService movieService;
	
	@GetMapping(produces="application/json")
	public ResponseEntity<List<Movie>> getMoviesList()
	{
		return new ResponseEntity<List<Movie>>(movieService.getAllMovies(),HttpStatus.OK);
	}
	
	@GetMapping(value="/{movieId}",produces="application/json")
	public ResponseEntity<Movie> getMovieDetails(@PathVariable String movieId)
	{
		Movie m= movieService.getByMovie(movieId);
		return  new ResponseEntity<Movie>(m,HttpStatus.OK);
	}
	
	@PostMapping(consumes="application/json")
	public HttpStatus addMovieDetails(@RequestBody Movie movie)
	{
		if(movieService.addMovieDetails(movie))
			return HttpStatus.OK;
		return HttpStatus.NOT_MODIFIED;
	}
	
	@DeleteMapping(value="/{movieId}",produces="application/json")
	public HttpStatus deleteMovie(@PathVariable String movieId)
	{
		movieService.removeMoviebyID(movieId);
		return HttpStatus.OK;
	}
	
	
	@ExceptionHandler(RuntimeException.class)
	public HttpStatus exceptionHandlerMethod()
	{
		return HttpStatus.NO_CONTENT;
	}
	
}
