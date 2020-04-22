package com.curso.exemplo.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.curso.exemplo.domain.Categoria;
import com.curso.exemplo.domain.Cliente;
import com.curso.exemplo.services.ClienteService;

@RestController
@RequestMapping(value = "/clientes")
public class ClienteResource {
	
	@Autowired
	ClienteService clienteService;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Cliente> consultar(@PathVariable Integer id) throws Exception{
		Cliente clienteConsultado = clienteService.buscarCliente(id);
		return ResponseEntity.ok(clienteConsultado);
	}
	
	@GetMapping
	public ResponseEntity<?> listar() throws Exception{
		
		List<Cliente> clientes = clienteService.listarClientes();
		
		return ResponseEntity.ok(clientes);
	}
	
}
