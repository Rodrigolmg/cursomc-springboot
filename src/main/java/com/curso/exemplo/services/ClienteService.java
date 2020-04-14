package com.curso.exemplo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.curso.exemplo.domain.Cliente;
import com.curso.exemplo.repositories.ClienteRepository;
import com.curso.exemplo.services.exceptions.ObjectNotFoundException;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;
	
	public Cliente buscarCliente(Integer id) throws Exception{
		
		Optional<Cliente> clienteConsultada = clienteRepository.findById(id);
		
		return clienteConsultada.orElseThrow(() -> new ObjectNotFoundException("Cliente não existe ou não está cadastrado(a)!"));
	}
	
	public List<Cliente> listarClientes() throws Exception{
		
		List<Cliente> categorias = clienteRepository.findAll();
		if(!Optional.ofNullable(categorias).isPresent() || categorias.isEmpty())
			throw new ObjectNotFoundException("Não há clientes cadastrados!");
		
		return categorias;
	}
}
