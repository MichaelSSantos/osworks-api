package com.algaworks.osworks.api.model;

import java.time.OffsetDateTime;

import lombok.Getter;
import lombok.Setter;

/**
 * Comentario é um subrecurso de OrdemServico.
 * 
 * URI de acesso: /ordens-servico/{id_da_os}/comentarios
 * Isso ocorre, porque somente pode existir um comentário caso esteja associado 
 * com uma ordem de serviço.
 * 
 * Model (DTO): Classe que representa o Comentario e que será apresentada ao cliente da API. 
 * A entidade de domínio possui o relacionamento com OrdemServico.
 * A representação a ser entregue ao cliente não deve possuir, pois o id da ordem de serviço irá trafegar na URL.
 */
@Getter
@Setter
public class ComentarioModel {

	private Long id;
	private String descricao;
	private OffsetDateTime dataEnvio;
	
}
