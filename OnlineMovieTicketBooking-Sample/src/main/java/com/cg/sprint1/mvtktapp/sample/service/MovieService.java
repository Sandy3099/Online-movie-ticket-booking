package com.cg.sprint1.mvtktapp.sample.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.cg.sprint1.mvtktapp.sample.entity.Movie;
import com.cg.sprint1.mvtktapp.sample.repository.MovieRepository;

@Service
public class MovieService 
{
	@Autowired
	MovieRepository movieRepository;
	
	@Transactional(readOnly=true)
	public Movie getByMovie(String movieId)
	{
		Optional<Movie> mvopt = movieRepository.findById(movieId);
		if(mvopt!=null)
			return mvopt.get();
		throw new RuntimeException("No movie by that name found");
	}
	
	@Transactional(readOnly=true)
	public List<Movie> getAllMovies()
	{
		List<Movie> mlist= movieRepository.findAll();
		if(mlist.size()>0)
			return mlist;
		throw new RuntimeException("No movies Available") ;
	}
	
	@Transactional
	public boolean addMovieDetails(Movie movie)
	{
		Movie mov = movieRepository.save(movie);
		return (mov!=null);
	}
	
	@Transactional(readOnly=false)
	public void removeMoviebyID(String movieId)
	{
		movieRepository.deleteById(movieId);
	}
}
