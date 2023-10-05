package com.services;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.excpetions.ResourceNotFoundException;
import com.model.Produto;
import com.repository.ProdutoRepository;


@Service
public class ProdutoServices {
	
	private Logger logger = Logger.getLogger(ProdutoServices.class.getName());
	
	@Autowired
	private ProdutoRepository repository;
	
	public Produto findById(Long id) {
		logger.info("Buscando um produto");
		return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Not found"));
	}
	
	public List<Produto> findAll() {
		logger.info("Buscando produtos cadastrados");
		return repository.findAll();
	}
	
	public Produto create(Produto produto) {
		logger.info("Criando um produto");
		return repository.saveAndFlush(produto);
	}
	
	public Produto update(Produto produto) {
		logger.info("Alterando um produto");
		Produto entity = repository.findById(produto.getId()).orElseThrow(() -> new ResourceNotFoundException("Not found"));
		entity.setNome(produto.getNome());
		entity.setValorCompra(produto.getValorCompra());
		entity.setValorVenda(produto.getValorVenda());
		entity.setValidade(produto.getValidade());
		entity.setDisponivel(produto.getDisponivel());
		return repository.saveAndFlush(entity);
	}
	
	public void delete(Long id) {
		logger.info("Deletando um produto");
		Produto entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Not found"));
		repository.delete(entity);
	}
}
