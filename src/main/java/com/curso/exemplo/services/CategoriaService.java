package com.curso.exemplo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.curso.exemplo.domain.Categoria;
import com.curso.exemplo.repositories.CategoriaRepository;

@Service
public class CategoriaService {

	@Autowired
	CategoriaRepository categoriaRepository;
	
	public Categoria buscarCategoria(Integer id) throws Exception{
		
		Optional<Categoria> categoriaConsultada = categoriaRepository.findById(id);
		
		return categoriaConsultada.orElseThrow(() -> new Exception("Categoria não encontrada!"));
	}
	
	public List<Categoria> listarCategorias() throws Exception{
		
		List<Categoria> categorias = categoriaRepository.findAll();
		if(!Optional.ofNullable(categorias).isPresent() || categorias.isEmpty())
			throw new Exception("Não há categorias cadastradas!");
		
		return categorias;
	}
}
