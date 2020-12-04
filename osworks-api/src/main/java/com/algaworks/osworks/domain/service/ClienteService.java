package com.algaworks.osworks.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.algaworks.osworks.domain.exception.NegocioException;
import com.algaworks.osworks.domain.model.Cliente;
import com.algaworks.osworks.domain.repository.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;

	public Cliente salvar(Cliente cliente) {
		Cliente clienteExistente = clienteRepository.findByEmail(cliente.getEmail());
		/* Se o cliente retornado for diferente de null e  
		 * Se o cliente retornado for diferente do que está sendo enviado para salvar, 
		 * então há uma tentativa de salvar um e-mail já usado por outro cliente.
		 * 
		 * Se o cliente retornado for diferente de null, mas 
		 * o cliente retornado for igual ao que está sendo enviado para salvar, então trata-se de uma atualização.
		 * */
		if (clienteExistente != null && !clienteExistente.equals(cliente)) {
			throw new NegocioException("E-mail já cadastrado.");
		}

		return clienteRepository.save(cliente);
	}

	public void excluir(Long id) {
		clienteRepository.deleteById(id);
	}

}
