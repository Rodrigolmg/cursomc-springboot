package com.curso.exemplo.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.curso.exemplo.domain.Categoria;
import com.curso.exemplo.domain.Estado;
import com.curso.exemplo.services.EstadoService;

@RestController
@RequestMapping(value = "/estados")
public class EstadoResource {
	
	@Autowired
	EstadoService estadoService;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<?> consultar(@PathVariable("id") Integer id) throws Exception{
		Estado categoriaConsultada = estadoService.buscarEstado(id);
		return ResponseEntity.ok(categoriaConsultada);
	}
	
	@GetMapping
	public ResponseEntity<?> listar() throws Exception{
		
		List<Estado> categorias = estadoService.listarEstados();
		
		return ResponseEntity.ok(categorias);
	}
	
}
