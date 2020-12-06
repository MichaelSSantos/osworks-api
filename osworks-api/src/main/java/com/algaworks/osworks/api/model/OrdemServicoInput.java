package com.algaworks.osworks.api.model;

import java.math.BigDecimal;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

/**
 * Classe usada para entrada de dados na API.
 * 
 * Existem atributos em OrdemServico que não devem ser enviados pelo cliente, 
 * pois são calculados pelo próprio sistema.  
 * Solução de contorno seria anotar cada atributo que não deve ser enviado pelo cliente 
 * com @JsonProperty(access = Access.READ_ONLY) ou usar um DTo específico para envio de dados.
 * 
 * Apenas o Id de cliente que se relaciona à OrdemServico deve ser validado.
 * Para evitar a criação de grupos de validação, criou-se ClienteIdInput para tratar essa regra.
 */
@Getter
@Setter
public class OrdemServicoInput {

	@Valid
	@NotNull
	private ClienteIdInput cliente;
	
	@NotBlank
	private String descricao;

	@NotNull
	private BigDecimal preco;
	
}
