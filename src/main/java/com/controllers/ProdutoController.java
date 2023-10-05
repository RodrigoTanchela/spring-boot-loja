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

import com.model.Produto;
import com.services.ProdutoServices;

@RestController
@RequestMapping("/api/produto/v1")
public class ProdutoController {
	
	@Autowired
	ProdutoServices service;
	
	@GetMapping(value = "/{id}")
	public Produto findById(@PathVariable(value = "id") Long id) {
		return service.findById(id);
	}
	
	@GetMapping
	public List<Produto> findAll() {
		return service.findAll();
	}
	
	@PostMapping
	public Produto create(Produto produto) {
		return service.create(produto);
	}
	
	@PutMapping
	public Produto update(Produto produto) {
		return service.create(produto);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}
