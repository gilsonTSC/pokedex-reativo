package com.gilsontsc.pokedex;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.ReactiveMongoOperations;

import com.gilsontsc.pokedex.model.Pokemon;
import com.gilsontsc.pokedex.repository.PokedexRepository;

import reactor.core.publisher.Flux;

@SpringBootApplication
public class PokedexApplication {

	public static void main(String[] args) {
		SpringApplication.run(PokedexApplication.class, args);
	}
	
	@Bean
	CommandLineRunner init(ReactiveMongoOperations operations, PokedexRepository repo) {
		return args -> {
			Flux<Pokemon> pokedexFlux = Flux.just(
					new Pokemon(null, "Bulbassauro", "Semente", "OverGrow", 6.09),
					new Pokemon(null, "Charizard", "Fogo", "Blaze", 90.05),
					new Pokemon(null, "Caterpie", "Minhoca", "Poeira de Escudo", 2.09),
					new Pokemon(null, "Blastoise", "Marisco", "Torrente", 6.09)
			)
			.flatMap(repo::save);
			
			pokedexFlux.thenMany(repo.findAll()).subscribe(System.out::println);
		};
	}

}