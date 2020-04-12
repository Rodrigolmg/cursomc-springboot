package com.curso.exemplo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.curso.exemplo.domain.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {

}
