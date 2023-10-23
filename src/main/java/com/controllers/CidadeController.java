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

import com.model.vo.CidadeVO;
import com.services.CidadeServices;

@RestController
@RequestMapping("/api/cidade/v1")
public class CidadeController {
	
	@Autowired
	CidadeServices service;
	
	@GetMapping(value = "/{id}")
	public CidadeVO findById(@PathVariable(value = "id") Long id) {
		return service.findById(id);
	}
	
	@GetMapping
	public List<CidadeVO> findAll() {
		return service.findAll();
	}
	
	@PostMapping
	public CidadeVO create(CidadeVO cidade) {
		return service.create(cidade);
	}
	
	@PutMapping
	public CidadeVO update(CidadeVO cidade) {
		return service.update(cidade);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}
