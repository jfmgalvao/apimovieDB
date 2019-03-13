package com.juliogalvao.apimovieDB.payloads;

import java.time.LocalDate;
import java.util.List;

public class MovieReponse {
	private Long id;
	private String title;
	private String overview;
	private String original_language;
	private LocalDate release_date;
	private Boolean adult;
	private List<Integer> genre_ids;
	private String original_title;
	private String backdrop_path;
	private String poster_path;
	private Integer vote_count;
	private Double popularity;
	private Boolean video;
	private Double vote_average;
	
	public MovieReponse(Long id, String title, String overview, String original_language, LocalDate release_date,
			Boolean adult, List<Integer> genre_ids, String original_title, String backdrop_path, String poster_path,
			Integer vote_count, Double popularity, Boolean video, Double vote_average) {
		this.id = id;
		this.title = title;
		this.overview = overview;
		this.original_language = original_language;
		this.release_date = release_date;
		this.adult = adult;
		this.genre_ids = genre_ids;
		this.original_title = original_title;
		this.backdrop_path = backdrop_path;
		this.poster_path = poster_path;
		this.vote_count = vote_count;
		this.popularity = popularity;
		this.video = video;
		this.vote_average = vote_average;
	}

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getOverview() {
		return overview;
	}
	
	public void setOverview(String overview) {
		this.overview = overview;
	}
	
	public String getOriginal_language() {
		return original_language;
	}
	
	public void setOriginal_language(String original_language) {
		this.original_language = original_language;
	}
	
	public LocalDate getRelease_date() {
		return release_date;
	}
	
	public void setRelease_date(LocalDate release_date) {
		this.release_date = release_date;
	}
	
	public Boolean getAdult() {
		return adult;
	}
	
	public void setAdult(Boolean adult) {
		this.adult = adult;
	}
	
	public List<Integer> getGenre_ids() {
		return genre_ids;
	}
	
	public void setGenre_ids(List<Integer> genre_ids) {
		this.genre_ids = genre_ids;
	}
	
	public String getOriginal_title() {
		return original_title;
	}
	
	public void setOriginal_title(String original_title) {
		this.original_title = original_title;
	}
	
	public String getBackdrop_path() {
		return backdrop_path;
	}
	
	public void setBackdrop_path(String backdrop_path) {
		this.backdrop_path = backdrop_path;
	}
	
	public String getPoster_path() {
		return poster_path;
	}
	
	public void setPoster_path(String poster_path) {
		this.poster_path = poster_path;
	}
	
	public Integer getVote_count() {
		return vote_count;
	}
	
	public void setVote_count(Integer vote_count) {
		this.vote_count = vote_count;
	}
	
	public Double getPopularity() {
		return popularity;
	}
	
	public void setPopularity(Double popularity) {
		this.popularity = popularity;
	}
	
	public Boolean getVideo() {
		return video;
	}
	
	public void setVideo(Boolean video) {
		this.video = video;
	}
	
	public Double getVote_average() {
		return vote_average;
	}

	public void setVote_average(Double vote_average) {
		this.vote_average = vote_average;
	}
}
