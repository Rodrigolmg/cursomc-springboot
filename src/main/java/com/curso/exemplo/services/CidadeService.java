package com.curso.exemplo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.curso.exemplo.domain.Categoria;
import com.curso.exemplo.domain.Cidade;
import com.curso.exemplo.repositories.CidadeRepository;
import com.curso.exemplo.services.exceptions.ObjectNotFoundException;

@Service
public class CidadeService {

	@Autowired
	private CidadeRepository cidadeRepository;
	
	public Cidade buscarCidade(Integer id) throws Exception{
		
		Optional<Cidade> cidadeConsultada = cidadeRepository.findById(id);
		
		return cidadeConsultada.orElseThrow(() -> new ObjectNotFoundException("Cidade não existe ou não está cadastrada!"));
	}
	
	public List<Cidade> listarCidades() throws Exception{
		
		List<Cidade> cidades = cidadeRepository.findAll();
		if(!Optional.ofNullable(cidades).isPresent() || cidades.isEmpty())
			throw new ObjectNotFoundException("Não há cidades cadastradas!");
		
		return cidades;
	}
}
