# Movie
Movie project to add, delete, update, find movies.

#Test cases 

/**
	 * @author Payal Agarwal
	 * @purpose used to add new movie
	 * @param movie
	 * @return status code
	 */
	@Test
	void addMovieTest() throws Exception {
		Movie movie = new Movie();
		movie.setTitle("d");
		movie.setCategory("C");
		movie.setStarRating(2.0f);

		RestTemplate restTemplate = new RestTemplate();
		final String baseUrl = "http://localhost:8080/addMovie";
		URI uri = new URI(baseUrl);
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<Movie> request = new HttpEntity<>(movie, headers);
		ResponseEntity<String> result = restTemplate.postForEntity(uri, request, String.class);
		assertEquals(200, result.getStatusCodeValue());
	}

	/**
	 * @author Payal Agarwal
	 * @purpose used to get Movie List
	 * @param
	 * @return movie list
	 */
	@Test
	void getMovieListTest() throws Exception {
		RestTemplate restTemplate = new RestTemplate();
		final String baseUrl = "http://localhost:8080/getMovieList";
		URI uri = new URI(baseUrl);
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<Movie> request = new HttpEntity<>(headers);
		ResponseEntity<List<Movie>> response = restTemplate.exchange(uri, HttpMethod.GET, request,
				new ParameterizedTypeReference<List<Movie>>() {
				});
		List<Movie> movieList = response.getBody();
		assertEquals(9, movieList.size());
		assertEquals(200, response.getStatusCodeValue());
	}

	/**
	 * @author Payal Agarwal
	 * @purpose used to get Movie by Id
	 * @param id
	 * @return movie data and status
	 */
	@Test
	void getMovieByIdTest() throws Exception {
		RestTemplate restTemplate = new RestTemplate();
		final String baseUrl = "http://localhost:8080/getMovieById/2";
		URI uri = new URI(baseUrl);
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<Movie> request = new HttpEntity<>(headers);
		ResponseEntity<Movie> response = restTemplate.exchange(uri, HttpMethod.GET, request,
				new ParameterizedTypeReference<Movie>() {
				});
		assertEquals(200, response.getStatusCodeValue());

	}
	
	/**
	 * @author Payal Agarwal
	 * @purpose used to update Movie
	 * @param movie
	 * @return status code
	 */
	@Test
	void updateMovieTest() throws Exception {
		Movie movie = new Movie();
		movie.setId(2L);
		movie.setTitle("d");
		movie.setCategory("C");
		movie.setStarRating(2.0f);
		RestTemplate restTemplate = new RestTemplate();
		final String baseUrl = "http://localhost:8080/updateMovie";
		URI uri = new URI(baseUrl);
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<Movie> request = new HttpEntity<>(movie, headers);
		ResponseEntity<String> response = restTemplate.exchange(uri, HttpMethod.PUT, request,
				new ParameterizedTypeReference<String>() {
				});
		assertEquals(200, response.getStatusCodeValue());

	}

	/**
	 * @author Payal Agarwal
	 * @purpose used to delete Movie by id
	 * @param id
	 * @return status code
	 */
	@Test
	void deleteMovieByIdTest() throws Exception {
		RestTemplate restTemplate = new RestTemplate();
		final String baseUrl = "http://localhost:8080/deleteMovieById/3";
		URI uri = new URI(baseUrl);
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<Movie> request = new HttpEntity<>(headers);
		ResponseEntity<String> response = restTemplate.exchange(uri, HttpMethod.DELETE, request,
				new ParameterizedTypeReference<String>() {
				});
		assertEquals(200, response.getStatusCodeValue());
	}

