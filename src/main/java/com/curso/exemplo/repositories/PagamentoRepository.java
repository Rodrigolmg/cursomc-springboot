package com.curso.exemplo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.curso.exemplo.domain.Pagamento;

public interface PagamentoRepository extends JpaRepository<Pagamento, Integer> {

}
