package com.movie.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movie.model.Movie;
import com.movie.repository.MovieRepository;
import com.movie.service.MovieService;

@Service
public class MovieServiceImpl implements MovieService {

	@Autowired
	MovieRepository movieRepository;

	@Override
	public Movie addMovie(Movie movie) {
		movieRepository.save(movie);
		return movie;
	}

	@Override
	public List<Movie> getMovieList() {
		return movieRepository.findAll();
	}

	@Override
	public Movie getMovieById(Long id) {
		if (movieRepository.existsById(id)) {
		Movie movie = movieRepository.findById(id).get();
		return movie;
	}	
		return null;
	}
	
	@Override
	public boolean deleteMovie(Long id) {
		if (!movieRepository.existsById(id)) {
			return false;
		} else {
			movieRepository.deleteById(id);
			return true;
		}
	}
}
