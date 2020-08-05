package com.gilsontsc.pokedex.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.gilsontsc.pokedex.model.Pokemon;

public interface PokedexRepository extends ReactiveMongoRepository<Pokemon, String>{

}