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

import com.model.Endereco;
import com.services.EnderecoServices;

@RestController
@RequestMapping("/api/endereco/v1")
public class EnderecoController {
	
	@Autowired
	EnderecoServices service;
	
	@GetMapping(value = "/{id}")
	public Endereco findById(@PathVariable(value = "id") Long id) {
		return service.findById(id);
	}
	
	@GetMapping
	public List<Endereco> findAll() {
		return service.findAll();
	}
	
	@PostMapping
	public Endereco create(Endereco endereco) {
		return service.create(endereco);
	}
	
	@PutMapping
	public Endereco update(Endereco endereco) {
		return service.create(endereco);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}
