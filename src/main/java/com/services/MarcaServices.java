package com.services;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.excpetions.ResourceNotFoundException;
import com.mapper.DozerMapper;
import com.model.Marca;
import com.model.vo.MarcaVO;
import com.repository.MarcaRepository;




@Service
public class MarcaServices {
	
	private Logger logger = Logger.getLogger(MarcaServices.class.getName());
	
	@Autowired
	private MarcaRepository repository;
	
	public List<MarcaVO> findAll() {
		logger.info("Finding all people");
		var marcas =  DozerMapper.parseListObject(repository.findAll(), MarcaVO.class);
		return marcas;
	}

	public MarcaVO findById(Long id) {
		logger.info("Finding one marca!");
		
		var entity = repository.findById(id).orElseThrow(()-> new ResourceNotFoundException("No records Found for this Id"));
		var vo = DozerMapper.parseObject(entity, MarcaVO.class);
		return vo;
	}
	
	public MarcaVO create(MarcaVO marca) {
		logger.info("Creating one marca!");
		var entity = DozerMapper.parseObject(marca, Marca.class);
		var vo = DozerMapper.parseObject(repository.save(entity), MarcaVO.class);
		return vo;
	}
	
	public MarcaVO update(MarcaVO marca) {
		logger.info("Alterando um marca");
		Marca entity = repository.findById(marca.getKey()).orElseThrow(() -> new ResourceNotFoundException("Not found"));
		entity.setNome(marca.getNome());
		var vo = DozerMapper.parseObject(repository.saveAndFlush(entity), MarcaVO.class);
		return vo;
	}
	
	public void delete(Long id) {
		logger.info("Deletando um marca");
		Marca entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Not found"));
		repository.delete(entity);
	}
}
