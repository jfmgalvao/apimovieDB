package com.juliogalvao.apimovieDB.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.juliogalvao.apimovieDB.model.MovieTheater;

public interface MovieTheaterRepository extends MongoRepository<MovieTheater, String> {
}
