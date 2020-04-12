package com.curso.exemplo.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.curso.exemplo.domain.Categoria;
import com.curso.exemplo.services.CategoriaService;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaResource {
	
	@Autowired
	CategoriaService categoriaService;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<?> consultar(@PathVariable("id") Integer id) throws Exception{
		Categoria categoriaConsultada = categoriaService.buscarCategoria(id);
		return ResponseEntity.ok(categoriaConsultada);
	}
	
	@GetMapping
	public ResponseEntity<?> listar() throws Exception{
		
		List<Categoria> categorias = categoriaService.listarCategorias();
		
		return ResponseEntity.ok(categorias);
	}
	
}
