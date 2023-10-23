package com.model.vo;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.dozermapper.core.Mapping;

public class CategoriaVO {
	
	@JsonProperty("id")
	@Mapping("id")
	private Long key;
	
	private String nome;
	
	public Long getKey() {
		return key;
	}
	public void setKey(Long key) {
		this.key = key;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	@Override
	public int hashCode() {
		return Objects.hash(key, nome);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CategoriaVO other = (CategoriaVO) obj;
		return Objects.equals(key, other.key) && Objects.equals(nome, other.nome);
	}
	
	
}
