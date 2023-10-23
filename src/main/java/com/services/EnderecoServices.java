package com.services;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.excpetions.ResourceNotFoundException;
import com.mapper.DozerMapper;
import com.model.Endereco;
import com.model.vo.EnderecoVO;
import com.repository.EnderecoRepository;



@Service
public class EnderecoServices {
	
	private Logger logger = Logger.getLogger(EnderecoServices.class.getName());
	
	@Autowired
	private EnderecoRepository repository;
	
	public List<EnderecoVO> findAll() {
		logger.info("Finding all people");
		var enderecos =  DozerMapper.parseListObject(repository.findAll(), EnderecoVO.class);
		return enderecos;
	}

	public EnderecoVO findById(Long id) {
		logger.info("Finding one endereco!");
		
		var entity = repository.findById(id).orElseThrow(()-> new ResourceNotFoundException("No records Found for this Id"));
		var vo = DozerMapper.parseObject(entity, EnderecoVO.class);
		return vo;
	}
	
	public EnderecoVO create(EnderecoVO endereco) {
		logger.info("Creating one endereco!");
		var entity = DozerMapper.parseObject(endereco, Endereco.class);
		var vo = DozerMapper.parseObject(repository.save(entity), EnderecoVO.class);
		return vo;
	}
	
	public EnderecoVO update(EnderecoVO endereco) {
		logger.info("Alterando um endereco");
		Endereco entity = repository.findById(endereco.getKey()).orElseThrow(() -> new ResourceNotFoundException("Not found"));
		entity.setBairro(endereco.getBairro());
		entity.setRua(endereco.getRua());
		entity.setCep(endereco.getCep());
		entity.setComplemento(endereco.getComplemento());
		var vo = DozerMapper.parseObject(repository.saveAndFlush(entity), EnderecoVO.class);
		return vo;
	}
	
	public void delete(Long id) {
		logger.info("Deletando um endereco");
		Endereco entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Not found"));
		repository.delete(entity);
	}
}
