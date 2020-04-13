package com.curso.exemplo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.curso.exemplo.domain.Cidade;

public interface CidadeRepository extends JpaRepository<Cidade, Integer> {

}
