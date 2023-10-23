package com.model.vo;

import java.io.Serializable;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.dozermapper.core.Mapping;

public class ProdutoVO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@JsonProperty("id")
	@Mapping("id")
	private Long key;
	
	private String nome;
	private Double valorCompra;
	private Double valorVenda;
	private String validade;
	private Boolean disponivel;
	private CategoriaVO categoria;	
	private MarcaVO marca;
	
	public ProdutoVO() {}

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

	public Double getValorCompra() {
		return valorCompra;
	}

	public void setValorCompra(Double valorCompra) {
		this.valorCompra = valorCompra;
	}

	public Double getValorVenda() {
		return valorVenda;
	}

	public void setValorVenda(Double valorVenda) {
		this.valorVenda = valorVenda;
	}

	public String getValidade() {
		return validade;
	}

	public void setValidade(String validade) {
		this.validade = validade;
	}

	public Boolean getDisponivel() {
		return disponivel;
	}

	public void setDisponivel(Boolean disponivel) {
		this.disponivel = disponivel;
	}

	public CategoriaVO getCategoria() {
		return categoria;
	}

	public void setCategoria(CategoriaVO categoria) {
		this.categoria = categoria;
	}

	public MarcaVO getMarca() {
		return marca;
	}

	public void setMarca(MarcaVO marca) {
		this.marca = marca;
	}

	@Override
	public int hashCode() {
		return Objects.hash(categoria, disponivel, key, marca, nome, validade, valorCompra, valorVenda);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProdutoVO other = (ProdutoVO) obj;
		return Objects.equals(categoria, other.categoria) && Objects.equals(disponivel, other.disponivel)
				&& Objects.equals(key, other.key) && Objects.equals(marca, other.marca)
				&& Objects.equals(nome, other.nome) && Objects.equals(validade, other.validade)
				&& Objects.equals(valorCompra, other.valorCompra) && Objects.equals(valorVenda, other.valorVenda);
	}
	
}
