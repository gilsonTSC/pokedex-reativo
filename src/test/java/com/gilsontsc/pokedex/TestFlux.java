package com.gilsontsc.pokedex;

import org.junit.jupiter.api.Test;

import reactor.core.publisher.Flux;

public class TestFlux {

	@Test
	public void testeFlux1() {
		Flux.empty();
	}
	
	@Test
	public void testeFlux2() {
		Flux<String> flux = Flux.just("Pokedex");
		flux.subscribe(System.out::println);
	}
	
	@Test
	public void testeFlux3() {
		Flux<String> flux = Flux.just("Sharizard", "Blastoise", "Pixachu");
		flux.subscribe(System.out::println);
	}
	
}