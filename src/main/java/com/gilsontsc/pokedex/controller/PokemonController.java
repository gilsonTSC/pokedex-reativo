package com.gilsontsc.pokedex.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.gilsontsc.pokedex.model.Pokemon;
import com.gilsontsc.pokedex.repository.PokedexRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/pokemons")
public class PokemonController {

	private PokedexRepository repo;
	
	public PokemonController(PokedexRepository repo) {
		this.repo = repo;
	}
	
	@GetMapping
	public Flux<Pokemon> getAllPokemons(){
		return this.repo.findAll();
	}
	
	@GetMapping("/{id}")
	public Mono<ResponseEntity<Pokemon>> getPokemon(@PathVariable String id){
		return this.repo.findById(id)
				.map(pokemon -> ResponseEntity.ok(pokemon))
				.defaultIfEmpty(ResponseEntity.notFound()
				.build());
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Mono<Pokemon> savePokemon(@RequestBody Pokemon pokemon){
		return this.repo.save(pokemon);
	}
	
}