package com.curso.exemplo.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.curso.exemplo.domain.Pedido;
import com.curso.exemplo.services.PedidoService;

@RestController
@RequestMapping(value = "/pedidos")
public class PedidoResource {
	
	@Autowired
	PedidoService pedidoService;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Pedido> consultar(@PathVariable Integer id) throws Exception{
		Pedido pedidoConsultado = pedidoService.buscarPedido(id);
		return ResponseEntity.ok(pedidoConsultado);
	}
	
	@GetMapping
	public ResponseEntity<?> listar() throws Exception{
		
		List<Pedido> pedidos = pedidoService.listarPedidos();
		
		return ResponseEntity.ok(pedidos);
	}
	
}
