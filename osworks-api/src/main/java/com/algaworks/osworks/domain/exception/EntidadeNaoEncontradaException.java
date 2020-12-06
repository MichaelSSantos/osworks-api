package com.algaworks.osworks.domain.exception;

/**
 * Exceção especializada para NegocioException.
 * Utilizada quando um recurso não é encontrado.
 */
public class EntidadeNaoEncontradaException extends NegocioException {

	private static final long serialVersionUID = 1L;

	public EntidadeNaoEncontradaException(String message) {
		super(message);
	}
}
