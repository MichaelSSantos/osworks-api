package com.algaworks.osworks.api.model;

import java.time.OffsetDateTime;

import com.algaworks.osworks.domain.model.StatusOrdemServico;

import lombok.Getter;
import lombok.Setter;

/**
 * Classe Representation Model de OrdemServico. 
 * Utilizada para transferência de dados na API.
 * 
 * Usada para apresentar os dados da API ao cliente.
 */
@Getter
@Setter
public class OrdemServicoModel {

	private Long id;
	/* Estratégia de correspondência de propriedades do ModelMapper.
	 * A estratégia padrão consegue fazer o math de Cliente.nome de OrdemServico em nomeCliente em OrdemServicoModel, 
	 * ou seja, 
	 * Domínio: [Atributo de objeto][atributo]
	 * DTO: [atributo][Atributo de Objeto]
	 * */
	//private String nomeCliente;
	
	/* Observe que o atributo cliente não está presente em OrdemServico. No entanto, o mapeamento é feito, porque 
	 * o ModelMapper verifica o nome do atributo e não o tipo.
	 * Assim, será possível criar representações (DTOs) específicos, sem mexer no domínio.
	 * */
	private ClienteResumoModel cliente;
	
	private String descricao;
	private StatusOrdemServico status;
	private OffsetDateTime dataAbertura;
	private OffsetDateTime dataFinalizacao;

}
