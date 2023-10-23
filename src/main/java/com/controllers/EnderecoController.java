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

import com.model.vo.EnderecoVO;
import com.services.EnderecoServices;

@RestController
@RequestMapping("/api/endereco/v1")
public class EnderecoController {
	
	@Autowired
	EnderecoServices service;
	
	@GetMapping(value = "/{id}")
	public EnderecoVO findById(@PathVariable(value = "id") Long id) {
		return service.findById(id);
	}
	
	@GetMapping
	public List<EnderecoVO> findAll() {
		return service.findAll();
	}
	
	@PostMapping
	public EnderecoVO create(EnderecoVO endereco) {
		return service.create(endereco);
	}
	
	@PutMapping
	public EnderecoVO update(EnderecoVO endereco) {
		return service.update(endereco);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}
