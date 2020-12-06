package com.algaworks.osworks.api.model;

import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

/**
 * DTO para entrada de dados de Comentario pelo cliente da API.
 * 
 * O ID de ordem de seviço será trafegado via URL, então este DTO 
 * não tem a necessidade de ter um atributo para armazenar o ID de ordem de serviço. 
 * 
 * O único campo a ser enviado pelo cliente é a descrição do comentário.
 */
@Getter
@Setter
public class ComentarioInput {

	@NotBlank
	private String descricao;
	
}
