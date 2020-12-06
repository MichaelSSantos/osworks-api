package com.algaworks.osworks.api.model;

import lombok.Getter;
import lombok.Setter;

/**
 * DTO usado para apresentar dados da API ao cliente.
 * Usado em conjunto com OrdemServicoModel
 */
@Getter
@Setter
public class ClienteResumoModel {

	private Long id;
	private String nome;

}
