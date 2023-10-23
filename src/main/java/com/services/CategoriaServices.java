package com.services;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.excpetions.ResourceNotFoundException;
import com.mapper.DozerMapper;
import com.model.Categoria;
import com.repository.CategoriaRepository;
import com.model.vo.CategoriaVO;



@Service
public class CategoriaServices {
	
	private Logger logger = Logger.getLogger(CategoriaServices.class.getName());
	
	@Autowired
	private CategoriaRepository repository;
	
	public List<CategoriaVO> findAll() {
		logger.info("Finding all people");
		var categorias =  DozerMapper.parseListObject(repository.findAll(), CategoriaVO.class);
		return categorias;
	}

	public CategoriaVO findById(Long id) {
		logger.info("Finding one categoria!");
		
		var entity = repository.findById(id).orElseThrow(()-> new ResourceNotFoundException("No records Found for this Id"));
		var vo = DozerMapper.parseObject(entity, CategoriaVO.class);
		return vo;
	}
	
	public CategoriaVO create(CategoriaVO categoria) {
		logger.info("Creating one categoria!");
		var entity = DozerMapper.parseObject(categoria, Categoria.class);
		var vo = DozerMapper.parseObject(repository.save(entity), CategoriaVO.class);
		return vo;
	}
	
	public CategoriaVO update(CategoriaVO categoria) {
		logger.info("Alterando uma categoria");
		var entity = repository.findById(categoria.getKey()).orElseThrow(() -> new ResourceNotFoundException("Not found"));
		entity.setNome(categoria.getNome());
		var vo = DozerMapper.parseObject(repository.save(entity), CategoriaVO.class);
		return vo;
	}
	
	public void delete(Long id) {
		logger.info("Deletando um categoria");
		Categoria entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Not found"));
		repository.delete(entity);
	}
}
