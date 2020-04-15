package com.curso.exemplo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.curso.exemplo.domain.Categoria;
import com.curso.exemplo.domain.Endereco;
import com.curso.exemplo.repositories.EnderecoRepository;
import com.curso.exemplo.services.exceptions.ObjectNotFoundException;

@Service
public class EnderecoService {

	@Autowired
	private EnderecoRepository enderecoRepository;
	
	public Endereco buscarEndereco(Integer id) throws Exception{
		
		Optional<Endereco> enderecoConsultado = enderecoRepository.findById(id);
		
		return enderecoConsultado.orElseThrow(() -> new ObjectNotFoundException("Endereço não existe ou não está cadastrado!"));
	}
	
	public List<Endereco> listarEnderecos() throws Exception{
		
		List<Endereco> enderecos = enderecoRepository.findAll();
		if(!Optional.ofNullable(enderecos).isPresent() || enderecos.isEmpty())
			throw new ObjectNotFoundException("Não há endereços cadastrados!");
		
		return enderecos;
	}
}
