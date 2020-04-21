package com.curso.exemplo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.curso.exemplo.domain.Pedido;
import com.curso.exemplo.services.exceptions.ObjectNotFoundException;
import com.curso.exemplo.repositories.PedidoRepository;

@Service
public class PedidoService {

	@Autowired
	private PedidoRepository pedidoRepository;
	
	public Pedido buscarPedido(Integer id) throws Exception{
		
		Optional<Pedido> pedidoConsultado = pedidoRepository.findById(id);
		
		return pedidoConsultado.orElseThrow(() -> new ObjectNotFoundException("Pedido não encontrado!"));
	}
	
	public List<Pedido> listarPedidos() throws Exception{
		
		List<Pedido> pedidos = pedidoRepository.findAll();
		if(!Optional.ofNullable(pedidos).isPresent() || pedidos.isEmpty())
			throw new ObjectNotFoundException("Não há pedidos cadastrados!");
		
		return pedidos;
	}
}
