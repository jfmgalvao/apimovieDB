package com.juliogalvao.apimovieDB.services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.juliogalvao.apimovieDB.model.Movie;
import com.juliogalvao.apimovieDB.model.MovieTheater;
import com.juliogalvao.apimovieDB.repositories.MovieTheaterRepository;

@Service
public class MovieService {
	
	@Autowired private MovieTheaterRepository movieTheaterRepository;

	public List<Movie> listMovieReleasesApi() throws IOException {
		RestTemplate restTemplate = new RestTemplate();
		String url = "https://api.themoviedb.org/3/movie/now_playing?api_key=b05fbf071a1935d714c478ebf091bcb3&language=pt-BR&page=1";
		ResponseEntity<String> responseEntity = restTemplate.getForEntity(url, String.class);
		ObjectMapper mapper = new ObjectMapper();
		JsonNode root = mapper.readTree(responseEntity.getBody());
		ArrayNode results = (ArrayNode) root.path("results");
		Iterator<JsonNode> iterator = results.elements();
		List<Movie> movies = new ArrayList<Movie>();

		while(iterator.hasNext()) {
			Movie movie = mapper.treeToValue(iterator.next(), Movie.class);
			movies.add(movie);
		}
		
		return movies;
	}
	
	public List<Movie> findByGenreIds(Integer genreIds) {
		List<MovieTheater> movieTheaters = movieTheaterRepository.findAll();
		List<Movie> movies = new ArrayList<Movie>();
		
		for (MovieTheater movieTheater : movieTheaters) {
			for (Movie movie : movieTheater.getListMovies()) {
				if(movie.getGenre_ids().contains(genreIds)) {
					movies.add(movie);
				}
			}
		}
		
		return movies;
	}
}
