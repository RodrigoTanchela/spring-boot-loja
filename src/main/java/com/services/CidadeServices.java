package com.services;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.excpetions.ResourceNotFoundException;
import com.mapper.DozerMapper;
import com.model.Cidade;
import com.model.vo.CidadeVO;
import com.repository.CidadeRepository;



@Service
public class CidadeServices {
	
	private Logger logger = Logger.getLogger(CidadeServices.class.getName());
	
	@Autowired
	private CidadeRepository repository;
	
	public List<CidadeVO> findAll() {
		logger.info("Finding all people");
		var categorias =  DozerMapper.parseListObject(repository.findAll(), CidadeVO.class);
		return categorias;
	}

	public CidadeVO findById(Long id) {
		logger.info("Finding one categoria!");
		
		var entity = repository.findById(id).orElseThrow(()-> new ResourceNotFoundException("No records Found for this Id"));
		var vo = DozerMapper.parseObject(entity, CidadeVO.class);
		return vo;
	}
	
	public CidadeVO create(CidadeVO cidade) {
		logger.info("Creating one categoria!");
		var entity = DozerMapper.parseObject(cidade, Cidade.class);
		var vo = DozerMapper.parseObject(repository.save(entity), CidadeVO.class);
		return vo;
	}
	
	public CidadeVO update(CidadeVO cidade) {
		logger.info("Alterando um cidade");
		Cidade entity = repository.findById(cidade.getKey()).orElseThrow(() -> new ResourceNotFoundException("Not found"));
		entity.setNome(cidade.getNome());
		var vo = DozerMapper.parseObject(repository.save(entity), CidadeVO.class);
		return vo;
	}
	
	public void delete(Long id) {
		logger.info("Deletando um cidade");
		Cidade entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Not found"));
		repository.delete(entity);
	}
}
