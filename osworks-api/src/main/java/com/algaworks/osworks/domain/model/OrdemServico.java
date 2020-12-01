package com.algaworks.osworks.domain.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(of = {"id"})
@Entity
public class OrdemServico {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@ManyToOne
	/* Join column implícito:
	 * 
	 * Poderia ter sido incluído a antoação @JoinColumn(name = "cliente_id")
	 * No entanto, quando não explicitada, o JPA identifica como FK o nome do atributo, no caso cliente + _ + id, 
	 * ficando com FK cliente_id em OrdemServico para identificar um relacionamento com cliente.
	 * 
	 * OBS.: Se o Hibernate não gerar as tabelas automaticamente, então a criação manual precisa respeitar essa regra. 
	 * */
	private Cliente cliente;
	
	@NotBlank
	private String descricao;
	
	@NotNull
	private BigDecimal preco;
	
	/* @JsonProperty(access = Access.READ_ONLY)
	 * Os atributos status, dataAbertura e dataFinalizacao são somente de leitura para o cliente. 
	 * O cliente não consegue enviar esses dados para o servidor, somente a aplicação pode processá-los.
	 * 
	 * Obs.: Mesmo que o cliente envie dados, ao chegarem no servidor, estes serão descartados.
	 * */
	@JsonProperty(access = Access.READ_ONLY)
	@Enumerated(EnumType.STRING)
	private StatusOrdemServico status;
	
	@JsonProperty(access = Access.READ_ONLY)
	private LocalDateTime dataAbertura;
	
	@JsonProperty(access = Access.READ_ONLY)
	private LocalDateTime dataFinalizacao;
	
}
