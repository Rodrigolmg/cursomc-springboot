package com.curso.exemplo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.curso.exemplo.domain.Estado;

public interface EstadoRepository extends JpaRepository<Estado, Integer> {

}
