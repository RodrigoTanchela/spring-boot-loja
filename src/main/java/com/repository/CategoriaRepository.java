package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long>{

}
