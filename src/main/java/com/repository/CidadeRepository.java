package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.model.Cidade;

public interface CidadeRepository extends JpaRepository<Cidade, Long> {

}
