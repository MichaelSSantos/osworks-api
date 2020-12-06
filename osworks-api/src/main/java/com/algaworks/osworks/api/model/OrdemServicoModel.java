package com.algaworks.osworks.api.model;

import java.time.OffsetDateTime;

import com.algaworks.osworks.domain.model.StatusOrdemServico;

import lombok.Getter;
import lombok.Setter;

/**
 * Classe Representation Model de OrdemServico. 
 * Utilizada para transferência de dados na API.
 */
@Getter
@Setter
public class OrdemServicoModel {

	private Long id;
	private String nomeCliente;
	private String descricao;
	private StatusOrdemServico status;
	private OffsetDateTime dataAbertura;
	private OffsetDateTime dataFinalizacao;

}
