package com.services;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.excpetions.ResourceNotFoundException;
import com.model.Produto;
import com.model.vo.ProdutoVO;
import com.repository.ProdutoRepository;

import com.mapper.DozerMapper;


@Service
public class ProdutoServices {
	
	private Logger logger = Logger.getLogger(ProdutoServices.class.getName());
	
	@Autowired
	private ProdutoRepository repository;
	
	public List<ProdutoVO> findAll() {
		logger.info("Finding all people");
		var produtos =  DozerMapper.parseListObject(repository.findAll(), ProdutoVO.class);
		return produtos;
	}

	public ProdutoVO findById(Long id) {
		logger.info("Finding one produto!");
		
		var entity = repository.findById(id).orElseThrow(()-> new ResourceNotFoundException("No records Found for this Id"));
		var vo = DozerMapper.parseObject(entity, ProdutoVO.class);
		return vo;
	}
	
	public ProdutoVO create(ProdutoVO produto) {
		logger.info("Creating one produto!");
		var entity = DozerMapper.parseObject(produto, Produto.class);
		var vo = DozerMapper.parseObject(repository.save(entity), ProdutoVO.class);
		return vo;
	}
	
	public ProdutoVO update(ProdutoVO produto) {
		logger.info("Alterando um produto");
		Produto entity = repository.findById(produto.getKey()).orElseThrow(() -> new ResourceNotFoundException("Not found"));
		entity.setNome(produto.getNome());
		entity.setValorCompra(produto.getValorCompra());
		entity.setValorVenda(produto.getValorVenda());
		entity.setValidade(produto.getValidade());
		entity.setDisponivel(produto.getDisponivel());
		var vo =  DozerMapper.parseObject(repository.saveAndFlush(entity), ProdutoVO.class);
		return vo;
	}
	
	public void delete(Long id) {
		logger.info("Deletando um produto");
		Produto entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Not found"));
		repository.delete(entity);
	}
}
