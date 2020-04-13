package com.curso.exemplo.domain.enums;

import java.util.Arrays;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum TipoCliente {

	PESSOAFISICA(1, "Pessoa Física"), 
	PESSOAJURIDICA(2, "Pessoa Jurídica");
	
	private int codigo;
	private String descricao;
	
	public static TipoCliente toEnum(Integer codigo) {
		return Arrays.asList(TipoCliente.values())
		.stream()
		.filter(tipoCodigo -> tipoCodigo.codigo == codigo)
		.findFirst().orElseThrow(() -> new IllegalArgumentException("ID inválido: " + codigo));
	}
}
