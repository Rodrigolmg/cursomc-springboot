package com.curso.exemplo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.curso.exemplo.domain.Categoria;
import com.curso.exemplo.domain.Estado;
import com.curso.exemplo.repositories.EstadoRepository;
import com.curso.exemplo.services.exceptions.ObjectNotFoundException;

@Service
public class EstadoService {

	@Autowired
	private EstadoRepository estadoRepository;
	
	public Estado buscarEstado(Integer id) throws Exception{
		
		Optional<Estado> estadoConsultado = estadoRepository.findById(id);
		
		return estadoConsultado.orElseThrow(() -> new ObjectNotFoundException("Este estado não existe ou não está cadatrado!"));
	}
	
	public List<Estado> listarEstados() throws Exception{
		
		List<Estado> categorias = estadoRepository.findAll();
		if(!Optional.ofNullable(categorias).isPresent() || categorias.isEmpty())
			throw new ObjectNotFoundException("Não há estados cadastrados!");
		
		return categorias;
	}
}
