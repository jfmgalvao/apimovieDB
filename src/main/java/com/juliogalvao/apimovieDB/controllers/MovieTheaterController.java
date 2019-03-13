package com.juliogalvao.apimovieDB.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.juliogalvao.apimovieDB.model.MovieTheater;
import com.juliogalvao.apimovieDB.payloads.MovieTheaterResponse;
import com.juliogalvao.apimovieDB.services.MovieService;
import com.juliogalvao.apimovieDB.services.MovieTheaterService;

@RestController
@RequestMapping(path = "/apimovieDB")
public class MovieTheaterController {
	@Autowired private MovieService movieService;
	@Autowired private MovieTheaterService movieTheaterService;
	
	@GetMapping("/moviesTheaters")
	public List<MovieTheaterResponse> getAll(){
		return movieTheaterService.getAllMovieTheater();
	}
	
	@GetMapping("/movieTheater/{id}")
	public MovieTheaterResponse getById(@PathVariable("id") String id) {
		return movieTheaterService.getById(id);
	}
	
	@PostMapping("/movieTheater")
	public ResponseEntity<?> create(@Valid @RequestBody MovieTheater movieTheater) {
		try {
			movieTheater.setListMovies(movieService.listMovieReleasesApi());
			movieTheaterService.create(movieTheater);
			
			return ResponseEntity.ok().build();
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}
	
	@PutMapping("/movieTheater/{id}")
	public ResponseEntity<?> update(@PathVariable("id") String id, @Valid @RequestBody MovieTheater movieTheater){
		try {
			movieTheaterService.update(id, movieTheater);
			
			return ResponseEntity.ok().build();
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}

	@DeleteMapping("/movieTheater/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") String id) {
		return movieTheaterService.delete(id);
	}
}
