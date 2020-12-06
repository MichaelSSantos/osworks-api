package com.algaworks.osworks.api.model;

import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * Classe usada para entrada de dados de cliente na API.
 * Usada em conjunto com OrdemServicoInput.
 */
@Getter
@Setter
public class ClienteIdInput {

	@NotNull
	private Long id;
	
}
