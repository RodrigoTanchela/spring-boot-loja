package com.model.vo;

import java.io.Serializable;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.dozermapper.core.Mapping;

public class CidadeVO implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@JsonProperty("id")
	@Mapping("id")
	private Long key;
	
	private String nome;
	
	public CidadeVO() {}

	public CidadeVO(Long key, String nome) {
		super();
		this.key = key;
		this.nome = nome;
	}

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
		CidadeVO other = (CidadeVO) obj;
		return Objects.equals(key, other.key) && Objects.equals(nome, other.nome);
	}
	
	
	
	
	
}
