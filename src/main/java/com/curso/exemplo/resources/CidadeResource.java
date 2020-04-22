package com.curso.exemplo.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.curso.exemplo.domain.Categoria;
import com.curso.exemplo.domain.Cidade;
import com.curso.exemplo.services.CidadeService;

@RestController
@RequestMapping(value = "/cidades")
public class CidadeResource {
	
	@Autowired
	CidadeService cidadeService;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Cidade> consultar(@PathVariable("id") Integer id) throws Exception{
		Cidade cidadeConsultada = cidadeService.buscarCidade(id);
		return ResponseEntity.ok(cidadeConsultada);
	}
	
	@GetMapping
	public ResponseEntity<?> listar() throws Exception{
		
		List<Cidade> cidades = cidadeService.listarCidades();
		
		return ResponseEntity.ok(cidades);
	}
	
}
