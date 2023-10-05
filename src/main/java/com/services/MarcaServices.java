package com.services;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.excpetions.ResourceNotFoundException;
import com.model.Marca;
import com.repository.MarcaRepository;


@Service
public class MarcaServices {
	
	private Logger logger = Logger.getLogger(MarcaServices.class.getName());
	
	@Autowired
	private MarcaRepository repository;
	
	public Marca findById(Long id) {
		logger.info("Buscando um marca");
		return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Not found"));
	}
	
	public List<Marca> findAll() {
		logger.info("Buscando marcas cadastrados");
		return repository.findAll();
	}
	
	public Marca create(Marca marca) {
		logger.info("Criando um marca");
		return repository.saveAndFlush(marca);
	}
	
	public Marca update(Marca marca) {
		logger.info("Alterando um marca");
		Marca entity = repository.findById(marca.getId()).orElseThrow(() -> new ResourceNotFoundException("Not found"));
		entity.setNome(marca.getNome());
		return repository.saveAndFlush(entity);
	}
	
	public void delete(Long id) {
		logger.info("Deletando um marca");
		Marca entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Not found"));
		repository.delete(entity);
	}
}
