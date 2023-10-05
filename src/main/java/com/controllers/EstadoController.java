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

import com.model.Estado;
import com.services.EstadoServices;

@RestController
@RequestMapping("/api/estado/v1")
public class EstadoController {
	
	@Autowired
	EstadoServices service;
	
	@GetMapping(value = "/{id}")
	public Estado findById(@PathVariable(value = "id") Long id) {
		return service.findById(id);
	}
	
	@GetMapping
	public List<Estado> findAll() {
		return service.findAll();
	}
	
	@PostMapping
	public Estado create(Estado estado) {
		return service.create(estado);
	}
	
	@PutMapping
	public Estado update(Estado estado) {
		return service.create(estado);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}
