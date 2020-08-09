package com.movie.service;

import java.util.List;

import com.movie.model.Movie;


public interface MovieService {

	public Movie addMovie(Movie movie);

	public List<Movie> getMovieList();

	public Movie getMovieById(Long id);

	public boolean deleteMovie(Long id);

	
	
}
