package com.algaworks.osworks.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * A estrutura do BD foi criada via Flyway. 
 * Foi utilizado o Jakarta Persistence para fazer o mapeamento objeto-relacional.
 */
@Getter
@Setter
@EqualsAndHashCode(of = {"id"})
@Entity
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	@Size(max=60)
	private String nome;

	@NotBlank
	@Email
	@Size(max=255)
	private String email;
	
	@NotBlank
	@Size(max=20)
	@Column(name = "phone")
	private String telefone;
	
}
