package com.curso.exemplo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.curso.exemplo.domain.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Integer> {

}
