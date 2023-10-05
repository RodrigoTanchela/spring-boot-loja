package com.services;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.excpetions.ResourceNotFoundException;
import com.model.Estado;
import com.repository.EstadoRepository;


@Service
public class EstadoServices {
	
	private Logger logger = Logger.getLogger(EstadoServices.class.getName());
	
	@Autowired
	private EstadoRepository repository;
	
	public Estado findById(Long id) {
		logger.info("Buscando um estado");
		return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Not found"));
	}
	
	public List<Estado> findAll() {
		logger.info("Buscando estados cadastrados");
		return repository.findAll();
	}
	
	public Estado create(Estado estado) {
		logger.info("Criando um estado");
		return repository.saveAndFlush(estado);
	}
	
	public Estado update(Estado estado) {
		logger.info("Alterando um estado");
		Estado entity = repository.findById(estado.getId()).orElseThrow(() -> new ResourceNotFoundException("Not found"));
		entity.setNome(estado.getNome());
		entity.setSigla(estado.getSigla());
		return repository.saveAndFlush(entity);
	}
	
	public void delete(Long id) {
		logger.info("Deletando um estado");
		Estado entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Not found"));
		repository.delete(entity);
	}
}
