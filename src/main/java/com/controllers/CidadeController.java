package com.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.model.Cidade;
import com.services.CidadeServices;

@RestController
@RequestMapping("/api/cidade/v1")
public class CidadeController {
	
	@Autowired
	CidadeServices service;
	
	@GetMapping(value = "/{id}")
	public Cidade findById(@PathVariable(value = "id") Long id) {
		return service.findById(id);
	}
	
	@GetMapping
	public List<Cidade> findAll() {
		return service.findAll();
	}
	
	@PostMapping
	public Cidade create(Cidade cidade) {
		return service.create(cidade);
	}
	
	@PutMapping
	public Cidade update(Cidade cidade) {
		return service.create(cidade);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}
