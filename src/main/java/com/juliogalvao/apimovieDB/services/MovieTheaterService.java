package com.juliogalvao.apimovieDB.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.juliogalvao.apimovieDB.model.MovieTheater;
import com.juliogalvao.apimovieDB.payloads.MovieTheaterResponse;
import com.juliogalvao.apimovieDB.repositories.MovieTheaterRepository;

@Service
public class MovieTheaterService {
	@Autowired private MovieTheaterRepository movieTheaterRepository;
	
	public List<MovieTheaterResponse> getAllMovieTheater() {
		List<MovieTheater> movieTheaters = movieTheaterRepository.findAll();
		List<MovieTheaterResponse> movieTheaterResponses = new ArrayList<MovieTheaterResponse>();
		
		if (movieTheaters.size() == 0) {
			return new ArrayList<>(Collections.emptyList());
		}		
		
		for(MovieTheater movieTheater : movieTheaters) {
			movieTheaterResponses.add(new MovieTheaterResponse(movieTheater));
		}
		
		return movieTheaterResponses;
	}
	
	public MovieTheaterResponse getById(String id) {
		Optional<MovieTheater> movieTheater = movieTheaterRepository.findById(id);
		
		return movieTheater.isPresent() ? new MovieTheaterResponse(movieTheater.get()) : null;
	}
	
	public MovieTheater create(MovieTheater movieTheater) {
		return movieTheaterRepository.save(movieTheater);
	}
	
	public MovieTheater update(String id, MovieTheater movieTheater) {
		Optional<MovieTheater> movieTheaterOld = movieTheaterRepository.findById(id);
		BeanUtils.copyProperties(movieTheater, movieTheaterOld.get(), "id");
		
		return movieTheaterRepository.save(movieTheaterOld.get());
	}
	
	public ResponseEntity<?> delete(String id) {
		Optional<MovieTheater> movieTheater = movieTheaterRepository.findById(id);
		
		try {
			movieTheaterRepository.delete(movieTheater.get());
			
			return ResponseEntity.ok().build();
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}
}
