package com.gilsontsc.pokedex.model;

import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Pokemon {

	@Id
	private String id;
	
	private String nome;
	
	private String categoria;
	
	private String habilidade;
	
	private Double peso;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getHabilidade() {
		return habilidade;
	}

	public void setHabilidade(String habilidade) {
		this.habilidade = habilidade;
	}

	public Double getPeso() {
		return peso;
	}

	public void setPeso(Double peso) {
		this.peso = peso;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, nome, categoria, habilidade, peso);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (!(obj instanceof Pokemon)) return false;
		Pokemon pokemon = (Pokemon) obj;
		return Objects.equals(id, pokemon.id) &&
				Objects.equals(nome,  pokemon.nome) &&
				Objects.equals(categoria,  pokemon.categoria) &&
				Objects.equals(habilidade,  pokemon.habilidade) &&
				Objects.equals(peso,  pokemon.peso);
	}

	@Override
	public String toString() {
		return "Pokemon {id=" + id + '\'' +
					  ", categoria=" + categoria +  '\'' +
					  ", habilidade=" + habilidade +  '\'' +
					  ", peso=" + peso + 
				"}";
	}
	
}