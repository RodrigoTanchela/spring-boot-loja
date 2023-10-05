package com.services;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.excpetions.ResourceNotFoundException;
import com.model.Categoria;
import com.repository.CategoriaRepository;


@Service
public class CategoriaServices {
	
	private Logger logger = Logger.getLogger(CategoriaServices.class.getName());
	
	@Autowired
	private CategoriaRepository repository;
	
	public Categoria findById(Long id) {
		logger.info("Buscando um categoria");
		return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Not found"));
	}
	
	public List<Categoria> findAll() {
		logger.info("Buscando categorias cadastrados");
		return repository.findAll();
	}
	
	public Categoria create(Categoria categoria) {
		logger.info("Criando um categoria");
		return repository.saveAndFlush(categoria);
	}
	
	public Categoria update(Categoria categoria) {
		logger.info("Alterando um categoria");
		Categoria entity = repository.findById(categoria.getId()).orElseThrow(() -> new ResourceNotFoundException("Not found"));
		entity.setNome(categoria.getNome());
		return repository.saveAndFlush(entity);
	}
	
	public void delete(Long id) {
		logger.info("Deletando um categoria");
		Categoria entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Not found"));
		repository.delete(entity);
	}
}
