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

import com.model.Categoria;
import com.services.CategoriaServices;

@RestController
@RequestMapping("/api/categoria/v1")
public class CategoriaController {
	
	@Autowired
	CategoriaServices service;
	
	@GetMapping(value = "/{id}")
	public Categoria findById(@PathVariable(value = "id") Long id) {
		return service.findById(id);
	}
	
	@GetMapping
	public List<Categoria> findAll() {
		return service.findAll();
	}
	
	@PostMapping
	public Categoria create(Categoria categoria) {
		return service.create(categoria);
	}
	
	@PutMapping
	public Categoria update(Categoria categoria) {
		return service.create(categoria);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}
