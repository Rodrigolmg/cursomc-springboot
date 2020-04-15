package com.curso.exemplo.domain.enums;

import java.util.Arrays;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum EstadoPagamento {

	PENDENTE(1, "Pendente"),
	QUITADO(2, "Quitado"),
	CANCELADO(3, "Cancelado");
	
	private int codigo;
	private String descricao;
	
	public static EstadoPagamento toEnum(Integer codigo) {
		return Arrays.asList(EstadoPagamento.values())
		.stream()
		.filter(tipoCodigo -> tipoCodigo.codigo == codigo)
		.findFirst().orElseThrow(() -> new IllegalArgumentException("ID inválido: " + codigo));
	}
}
