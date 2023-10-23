package com.services;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.excpetions.ResourceNotFoundException;
import com.mapper.DozerMapper;
import com.model.Estado;
import com.model.vo.EstadoVO;
import com.repository.EstadoRepository;


@Service
public class EstadoServices {
	
	private Logger logger = Logger.getLogger(EstadoServices.class.getName());
	
	@Autowired
	private EstadoRepository repository;
	
	public List<EstadoVO> findAll() {
		logger.info("Finding all people");
		var estados =  DozerMapper.parseListObject(repository.findAll(), EstadoVO.class);
		return estados;
	}

	public EstadoVO findById(Long id) {
		logger.info("Finding one estado!");
		
		var entity = repository.findById(id).orElseThrow(()-> new ResourceNotFoundException("No records Found for this Id"));
		var vo = DozerMapper.parseObject(entity, EstadoVO.class);
		return vo;
	}
	
	public EstadoVO create(EstadoVO estado) {
		logger.info("Creating one estado!");
		var entity = DozerMapper.parseObject(estado, Estado.class);
		var vo = DozerMapper.parseObject(repository.save(entity), EstadoVO.class);
		return vo;
	}
	
	public EstadoVO update(EstadoVO estado) {
		logger.info("Alterando um estado");
		Estado entity = repository.findById(estado.getKey()).orElseThrow(() -> new ResourceNotFoundException("Not found"));
		entity.setNome(estado.getNome());
		entity.setSigla(estado.getSigla());
		var vo = DozerMapper.parseObject(repository.saveAndFlush(entity), EstadoVO.class);
		return vo;
	}
	
	public void delete(Long id) {
		logger.info("Deletando um estado");
		Estado entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Not found"));
		repository.delete(entity);
	}
}
