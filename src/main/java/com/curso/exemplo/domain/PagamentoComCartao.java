package com.curso.exemplo.domain;


import javax.persistence.Entity;

import com.curso.exemplo.domain.enums.EstadoPagamento;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class PagamentoComCartao extends Pagamento {

	
	private static final long serialVersionUID = 5921577156268288220L;
	
	private Integer numeroDeParcelas;

	public PagamentoComCartao(@NonNull EstadoPagamento estado, @NonNull Pedido pedido, @NonNull Integer numeroDeParcelas) {
		super(estado, pedido);
		this.numeroDeParcelas = numeroDeParcelas;
	}
	
	
}
