package com.algaworks.osworks.api.exceptionhandler;

import java.time.OffsetDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
/**
 * O Jackson irá fazer o binding apenas de campos que não estão nulos. 
 * Apenas retornará para o cliente os atributos que possuem algum valor.
 */
@JsonInclude(Include.NON_NULL)
public class ExceptionObject {

	private Integer status;
	private OffsetDateTime dataHora;
	private String titulo;
	private List<Campo> campos;

	@Data
	@NoArgsConstructor
	@AllArgsConstructor
	public static class Campo {
		private String nome;
		private String mensagem;
	}

}
