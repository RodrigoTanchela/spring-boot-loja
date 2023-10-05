package com.services;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.excpetions.ResourceNotFoundException;
import com.model.CarrinhoCompra;
import com.repository.CarrinhoCompraRepository;


@Service
public class CarrinhoCompraServices {
	
	private Logger logger = Logger.getLogger(CarrinhoCompraServices.class.getName());
	
	@Autowired
	private CarrinhoCompraRepository repository;
	
	public CarrinhoCompra findById(Long id) {
		logger.info("Buscando um carrinho Compra");
		return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Not found"));
	}
	
	public List<CarrinhoCompra> findAll() {
		logger.info("Buscando carrinho Compras cadastrados");
		return repository.findAll();
	}
	
	public CarrinhoCompra create(CarrinhoCompra carrinhoCompra) {
		logger.info("Criando um carrinho Compra");
		return repository.saveAndFlush(carrinhoCompra);
	}
	
	public CarrinhoCompra update(CarrinhoCompra carrinhoCompra) {
		logger.info("Alterando um carrinho Compra");
		CarrinhoCompra entity = repository.findById(carrinhoCompra.getId()).orElseThrow(() -> new ResourceNotFoundException("Not found"));
		entity.setDataCompra(carrinhoCompra.getDataCompra());
		entity.setObservacao(carrinhoCompra.getObservacao());
		entity.setSituacao(carrinhoCompra.getSituacao());
		entity.setProdutos(carrinhoCompra.getProdutos());
		return repository.saveAndFlush(entity);
	}
	
	public void delete(Long id) {
		logger.info("Deletando um carrinho Compra");
		CarrinhoCompra entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Not found"));
		repository.delete(entity);
	}
}
