package com.curso.exemplo.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.curso.exemplo.domain.Categoria;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaResource {
	
	@GetMapping(value = "/{id}")
	public Categoria consultar(@PathVariable("id") Integer id) {
		
		Categoria cat1 = new Categoria();
		Categoria cat2 = new Categoria();
		
		cat1.setId(1);
		cat2.setId(2);
		
		cat1.setNome("Informática");
		cat2.setNome("Escritório");
		
		List<Categoria> categorias = new ArrayList<>();
		
		categorias.add(cat1);
		categorias.add(cat2);
		
		return categorias.get(id - 1);
	}
	
	@GetMapping
	public List<Categoria> listar() {
		
		Categoria cat1 = new Categoria();
		Categoria cat2 = new Categoria();
		
		cat1.setId(1);
		cat2.setId(2);
		
		cat1.setNome("Informática");
		cat2.setNome("Escritório");

		List<Categoria> categorias = new ArrayList<>();
		
		categorias.add(cat1);
		categorias.add(cat2);
		
		return categorias;
	}
	
}
