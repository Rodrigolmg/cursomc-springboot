package com.curso.exemplo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.curso.exemplo.domain.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {

}
