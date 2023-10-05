package com.services;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.excpetions.ResourceNotFoundException;
import com.model.Cidade;
import com.repository.CidadeRepository;


@Service
public class CidadeServices {
	
	private Logger logger = Logger.getLogger(CidadeServices.class.getName());
	
	@Autowired
	private CidadeRepository repository;
	
	public Cidade findById(Long id) {
		logger.info("Buscando um cidade");
		return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Not found"));
	}
	
	public List<Cidade> findAll() {
		logger.info("Buscando cidades cadastrados");
		return repository.findAll();
	}
	
	public Cidade create(Cidade cidade) {
		logger.info("Criando um cidade");
		return repository.saveAndFlush(cidade);
	}
	
	public Cidade update(Cidade cidade) {
		logger.info("Alterando um cidade");
		Cidade entity = repository.findById(cidade.getId()).orElseThrow(() -> new ResourceNotFoundException("Not found"));
		entity.setNome(cidade.getNome());
		return repository.saveAndFlush(entity);
	}
	
	public void delete(Long id) {
		logger.info("Deletando um cidade");
		Cidade entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Not found"));
		repository.delete(entity);
	}
}
