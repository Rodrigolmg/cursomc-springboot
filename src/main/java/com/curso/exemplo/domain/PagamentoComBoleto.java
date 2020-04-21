package com.curso.exemplo.domain;

import java.util.Date;

import javax.persistence.Entity;

import com.curso.exemplo.domain.enums.EstadoPagamento;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class PagamentoComBoleto extends Pagamento {
	
	
	private static final long serialVersionUID = 8976650783079632665L;

	@JsonFormat(pattern = "dd/mm/yyyy HH:mm")
	private Date dataVencimento;
	
	@JsonFormat(pattern = "dd/mm/yyyy HH:mm")
	private Date dataPagamento;


	public PagamentoComBoleto(@NonNull EstadoPagamento estado, @NonNull Pedido pedido,
			@NonNull Date dataVencimento) {
		super(estado, pedido);
		this.dataVencimento = dataVencimento;
		// TODO Auto-generated constructor stub
	}
	
	
}
