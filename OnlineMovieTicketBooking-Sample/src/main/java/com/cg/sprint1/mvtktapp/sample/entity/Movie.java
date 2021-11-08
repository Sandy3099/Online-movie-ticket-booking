package com.cg.sprint1.mvtktapp.sample.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name="movie")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property="movieId")
public class Movie 
{
	@Id
	@Column(name="movie_id")
	String movieId;
	
	@Column(name="movie_name")
	String movieName;
	
	@Column(name="cast_and_crew")
	String castAndCrew;
	
	@Column(name="movie_language")
	String movieLanguage;
	
	@Column(name="movie_category")
	String movieCategory;
	
	@Column(name="movie_duration")
	int movieRunTime;
	
	@OneToMany(fetch=FetchType.EAGER,mappedBy="movie")
	List<Show> show;

	public Movie() {}

	public Movie(String movieId, String movieName, String castAndCrew, String movieLanguage, String movieCategory,int movieRunTime, List<Show> show) 
	{
		super();
		this.movieId = movieId;
		this.movieName = movieName;
		this.castAndCrew = castAndCrew;
		this.movieLanguage = movieLanguage;
		this.movieCategory = movieCategory;
		this.movieRunTime = movieRunTime;
		this.show = show;
	}

	public String getMovieId() {
		return movieId;
	}

	public void setMovieId(String movieId) {
		this.movieId = movieId;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public String getCastAndCrew() {
		return castAndCrew;
	}

	public void setCastAndCrew(String castAndCrew) {
		this.castAndCrew = castAndCrew;
	}

	public String getMovieLanguage() {
		return movieLanguage;
	}

	public void setMovieLanguage(String movieLanguage) {
		this.movieLanguage = movieLanguage;
	}

	public String getMovieCategory() {
		return movieCategory;
	}

	public void setMovieCategory(String movieCategory) {
		this.movieCategory = movieCategory;
	}

	public int getMovieRunTime() {
		return movieRunTime;
	}

	public void setMovieRunTime(int movieRunTime) {
		this.movieRunTime = movieRunTime;
	}

	public List<Show> getShow() {
		return show;
	}

	public void setShow(List<Show> show) {
		this.show = show;
	}

	
	
}
