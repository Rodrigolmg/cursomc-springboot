package com.curso.exemplo.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Endereco implements Serializable {
	
	private static final long serialVersionUID = 5297820284322845409L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NonNull
	private String logradouro;
	
	@NonNull
	private String numero;
	
	@NonNull
	private String complemento;
	
	@NonNull
	private String bairro;
	
	@NonNull
	private String cep;

	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "cliente_id")
	@NonNull
	private Cliente cliente;
	
	@ManyToOne
	@JoinColumn(name = "cidade_id")
	@NonNull
	private Cidade cidade;
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Endereco other = (Endereco) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	
	
}
