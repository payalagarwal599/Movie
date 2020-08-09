package com.movie.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.movie.model.Movie;
import com.movie.service.MovieService;

@RestController
public class MovieController {

	@Autowired
	MovieService movieService;

	/**
	 * @author Payal Agarwal
	 * @purpose used to add new movie
	 * @param movie
	 * @return Message and status
	 */
	@PostMapping("/addMovie")
	public ResponseEntity<?> addMovie(@RequestBody(required = false) Movie movie) {
		if (movie.getTitle() != null && movie.getCategory() != null && movie.getStarRating() != null)
			movie = movieService.addMovie(movie);
		else
		return new ResponseEntity<>("Please check the values provided", HttpStatus.BAD_REQUEST);
		return new ResponseEntity<>("Movie Added Successfully",HttpStatus.OK);
	}

	/**
	 * @author Payal Agarwal
	 * @purpose used to get Movie List
	 * @param
	 * @return movie list
	 */
	@GetMapping("/getMovieList")
	public ResponseEntity<?> getMovieList() {
		List<Movie> movieList = movieService.getMovieList();
		return new ResponseEntity<>(movieList, HttpStatus.OK);
	}

	/**
	 * @author Payal Agarwal
	 * @purpose used to get Movie by Id
	 * @param id
	 * @return movie data and status
	 */
	@GetMapping("/getMovieById/{id}")
	public ResponseEntity<?> getMovieById(@PathVariable Long id) {
		Movie movie = movieService.getMovieById(id);
		if (movie != null)
			return new ResponseEntity<>(movie, HttpStatus.OK);
		else
			return new ResponseEntity<>("Movie do not exist", HttpStatus.NOT_FOUND);
	}

	/**
	 * @author Payal Agarwal
	 * @purpose used to update Movie
	 * @param movie
	 * @return message and status
	 */
	@PutMapping("/updateMovie")
	public ResponseEntity<?> updateMovie(@RequestBody Movie movie) {
		if (movie.getTitle() != null && movie.getCategory() != null && movie.getStarRating() != null) {
			movie = movieService.addMovie(movie);
			return new ResponseEntity<>("Movie updated successfully",HttpStatus.OK);
		} else
			return new ResponseEntity<>("Please check the values provided", HttpStatus.BAD_REQUEST);
	}

	/**
	 * @author Payal Agarwal
	 * @purpose used to delete Movie by id
	 * @param id
	 * @return message and status
	 */
	@DeleteMapping("/deleteMovieById/{id}")
	public ResponseEntity<?> deleteMovieById(@PathVariable Long id) {
		if (movieService.deleteMovie(id))
			return new ResponseEntity<>("Id deleted successfully",HttpStatus.OK);
		else
			return new ResponseEntity<>("Id do not exist", HttpStatus.NOT_FOUND);

	}

}
