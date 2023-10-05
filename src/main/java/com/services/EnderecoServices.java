package com.services;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.excpetions.ResourceNotFoundException;
import com.model.Endereco;
import com.repository.EnderecoRepository;


@Service
public class EnderecoServices {
	
	private Logger logger = Logger.getLogger(EnderecoServices.class.getName());
	
	@Autowired
	private EnderecoRepository repository;
	
	public Endereco findById(Long id) {
		logger.info("Buscando um endereco");
		return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Not found"));
	}
	
	public List<Endereco> findAll() {
		logger.info("Buscando enderecos cadastrados");
		return repository.findAll();
	}
	
	public Endereco create(Endereco endereco) {
		logger.info("Criando um endereco");
		return repository.saveAndFlush(endereco);
	}
	
	public Endereco update(Endereco endereco) {
		logger.info("Alterando um endereco");
		Endereco entity = repository.findById(endereco.getId()).orElseThrow(() -> new ResourceNotFoundException("Not found"));
		entity.setBairro(endereco.getBairro());
		entity.setRua(endereco.getRua());
		entity.setCep(endereco.getCep());
		entity.setComplemento(endereco.getComplemento());
		return repository.saveAndFlush(entity);
	}
	
	public void delete(Long id) {
		logger.info("Deletando um endereco");
		Endereco entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Not found"));
		repository.delete(entity);
	}
}
