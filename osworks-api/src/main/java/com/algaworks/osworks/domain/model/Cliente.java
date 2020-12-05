package com.algaworks.osworks.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.algaworks.osworks.domain.ValidationGroups;

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
	
	/* NotNull em Id:
	 * id de cliente não pode ser nulo quando uma ordem de serviço for salva. Ver OrdemService.java
	 * Na validação de cliente, o grupo padrão é o Default.class que valida tudo, 
	 * mas está sendo especificado que o id será validado somente quando for utilizado o grupo 
	 * ValidationGroups.ClienteId.class, que ocorre no cascateamento da validação por OrdemServico.java
	 * */
	@NotNull(groups = ValidationGroups.ClienteId.class)
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
