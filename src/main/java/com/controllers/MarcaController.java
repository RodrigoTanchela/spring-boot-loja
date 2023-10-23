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

import com.model.vo.MarcaVO;
import com.services.MarcaServices;

@RestController
@RequestMapping("/api/marca/v1")
public class MarcaController {
	
	@Autowired
	MarcaServices service;
	
	@GetMapping(value = "/{id}")
	public MarcaVO findById(@PathVariable(value = "id") Long id) {
		return service.findById(id);
	}
	
	@GetMapping
	public List<MarcaVO> findAll() {
		return service.findAll();
	}
	
	@PostMapping
	public MarcaVO create(MarcaVO marca) {
		return service.create(marca);
	}
	
	@PutMapping
	public MarcaVO update(MarcaVO marca) {
		return service.update(marca);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}
