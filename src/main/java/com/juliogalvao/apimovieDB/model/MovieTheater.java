package com.juliogalvao.apimovieDB.model;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "movie_theater")
public class MovieTheater {
	private String id;
	private String name;
	private String address;
	private LocalDate creationDate;
	private LocalDate lastModify;
	private List<Movie> listMovies;
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public LocalDate getCreationDate() {
		return creationDate;
	}
	
	public void setCreationDate(LocalDate creationDate) {
		this.creationDate = creationDate;
	}
	
	public LocalDate getLastModify() {
		return lastModify;
	}
	
	public void setLastModify(LocalDate lastModify) {
		this.lastModify = lastModify;
	}
	
	public List<Movie> getListMovies() {
		return listMovies;
	}

	public void setListMovies(List<Movie> listMovies) {
		this.listMovies = listMovies;
	}
}
