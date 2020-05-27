package com.curso.exemplo.dto;

import java.io.Serializable;

import com.curso.exemplo.domain.Categoria;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CategoriaDTO implements Serializable{

	private static final long serialVersionUID = -8854518774554653481L;
	
	private Integer id;
	private String nome;
	
	public CategoriaDTO(Categoria categoria) {
		this.id = categoria.getId();
		this.nome = categoria.getNome();
	}
	
}
