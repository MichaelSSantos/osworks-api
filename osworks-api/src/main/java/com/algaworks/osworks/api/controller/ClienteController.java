package com.algaworks.osworks.api.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.osworks.domain.model.Cliente;
import com.algaworks.osworks.domain.repository.ClienteRepository;
import com.algaworks.osworks.domain.service.ClienteService;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

//	@PersistenceContext
//	private EntityManager manager;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private ClienteService clienteService;

	@GetMapping
	public List<Cliente> listar() {
		
		/* Foi criada a estrutura DDL da classe cliente via Flyway no BD.
		 * Feito o mapeamento objeto-relacional do jakarta persistence 
		 * Injetado o EntityManager para obtenção dos dados de cliente.
		 * Observe que não foi necessário criar um repository do Spring Data JPA.  
		 * Poderia existir um repository para obtenção de dados e outra classe para usar o EntityManager.*/
//		return manager.createQuery("from Cliente", Cliente.class).getResultList();
		
//		return clienteRepository.findByNomeContaining("a");
		return clienteRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Cliente> buscar(@PathVariable Long id) {
		Optional<Cliente> cliente = clienteRepository.findById(id);
		
		return cliente.isPresent() ? ResponseEntity.ok(cliente.get()) : ResponseEntity.notFound().build();
	}

	/**
	 * @RequestBody: Transforma o objeto JSON em objeto Java
	 */
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Cliente adicionar(@Valid @RequestBody Cliente cliente) {
		return clienteService.salvar(cliente);
	}
	
	/**
	 * PUT no REST:
	 * Não enviar o id no corpo da requisição, apenas na URI. 
	 */
	@PutMapping("/{id}")
	public ResponseEntity<?> atualizar(@PathVariable Long id, @RequestBody Cliente cliente) {
		
		if(!clienteRepository.existsById(id)) {
			return ResponseEntity.notFound().build(); 
		}
		
		cliente.setId(id);
		cliente = clienteService.salvar(cliente);
		
		return ResponseEntity.ok(cliente);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> remover(@PathVariable Long id){
		
		if(!clienteRepository.existsById(id)) {
			return ResponseEntity.notFound().build(); 
		}
		
		clienteService.excluir(id);
		
		return ResponseEntity.noContent().build();
	}
}
