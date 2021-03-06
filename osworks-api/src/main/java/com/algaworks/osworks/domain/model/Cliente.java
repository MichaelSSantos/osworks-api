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
 * Toda a validação está sendo realizada pelo representation model, logo não
 * torna-se mais necessária as anotações no modelo de domínio. Ver
 * ClienteOld.java
 * 
 * Nesse curso foram apenas criadas classes DTO para OrdemServico, logo as
 * anotações de validação foram mantidas em cliente, exceto em id, que é utiliza
 * apenas em OrdemServico. Ver clienteOld.java
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
