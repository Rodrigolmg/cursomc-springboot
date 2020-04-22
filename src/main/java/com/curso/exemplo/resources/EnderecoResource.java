package com.curso.exemplo.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.curso.exemplo.domain.Categoria;
import com.curso.exemplo.domain.Endereco;
import com.curso.exemplo.services.EnderecoService;

@RestController
@RequestMapping(value = "/enderecos")
public class EnderecoResource {
	
	@Autowired
	EnderecoService enderecoService;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Endereco> consultar(@PathVariable Integer id) throws Exception{
		Endereco enderecoConsultado = enderecoService.buscarEndereco(id);
		return ResponseEntity.ok(enderecoConsultado);
	}
	
	@GetMapping
	public ResponseEntity<?> listar() throws Exception{
		
		List<Endereco> enderecos = enderecoService.listarEnderecos();
		
		return ResponseEntity.ok(enderecos);
	}
	
}
