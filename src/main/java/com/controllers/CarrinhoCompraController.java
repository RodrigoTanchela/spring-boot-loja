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

import com.model.CarrinhoCompra;
import com.services.CarrinhoCompraServices;

@RestController
@RequestMapping("/api/carrinhoCompra/v1")
public class CarrinhoCompraController {
	
	@Autowired
	CarrinhoCompraServices service;
	
	@GetMapping(value = "/{id}")
	public CarrinhoCompra findById(@PathVariable(value = "id") Long id) {
		return service.findById(id);
	}
	
	@GetMapping
	public List<CarrinhoCompra> findAll() {
		return service.findAll();
	}
	
	@PostMapping
	public CarrinhoCompra create(CarrinhoCompra carrinhoCompra) {
		return service.create(carrinhoCompra);
	}
	
	@PutMapping
	public CarrinhoCompra update(CarrinhoCompra carrinhoCompra) {
		return service.create(carrinhoCompra);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}
