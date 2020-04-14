package com.curso.exemplo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.curso.exemplo.domain.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

}
