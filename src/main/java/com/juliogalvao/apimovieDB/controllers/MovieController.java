package com.juliogalvao.apimovieDB.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.juliogalvao.apimovieDB.model.Movie;
import com.juliogalvao.apimovieDB.services.MovieService;

@RestController
@RequestMapping(path = "/apimovieDB/movie")
public class MovieController {
	
	@Autowired private MovieService movieService;
 	
	@GetMapping("/moviesByGenre/{id}")
	public List<Movie> getAll(@PathVariable("id") Integer id){
		return movieService.findByGenreIds(id);
	}
}
