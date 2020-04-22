package com.curso.exemplo.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.curso.exemplo.domain.Categoria;
import com.curso.exemplo.services.CategoriaService;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaResource {
	
	@Autowired
	private CategoriaService categoriaService;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Categoria> consultar(@PathVariable Integer id) throws Exception{
		Categoria categoriaConsultada = categoriaService.buscarCategoria(id);
		return ResponseEntity.ok(categoriaConsultada);
	}
	
	@GetMapping
	public ResponseEntity<?> listar() throws Exception{
		
		List<Categoria> categorias = categoriaService.listarCategorias();
		
		return ResponseEntity.ok(categorias);
	}
	
	@PostMapping(value = "/add")
	public ResponseEntity<Void> adicionar(@RequestBody Categoria categoria){
		
		Categoria categoriaCadastrada = categoriaService.cadastrarCategoria(categoria);
		URI uri = ServletUriComponentsBuilder
					.fromCurrentContextPath()
					.path("/categorias/{id}")
					.buildAndExpand(categoriaCadastrada.getId())
					.toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping(value = "/update/{id}")
	public ResponseEntity<Void> atualizar(@RequestBody Categoria categoria, @PathVariable Integer id){
		categoria.setId(id);
		Categoria categoriaAtualizada = this.categoriaService.atualizarCategoria(categoria);
		
		return ResponseEntity.noContent().build();
	}
	
}
