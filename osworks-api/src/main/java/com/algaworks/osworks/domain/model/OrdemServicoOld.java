package com.algaworks.osworks.domain.model;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.groups.ConvertGroup;
import javax.validation.groups.Default;

import com.algaworks.osworks.domain.ValidationGroups;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(of = {"id"})
@Entity
//@JsonInclude(Include.NON_NULL)//Não retorna campos nulos.
public class OrdemServicoOld {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Valid//Faz o cascateamento da validação, ou seja, valida os atributos de cliente.
	/* Quando o Bean Validation faz a validação, por padrão ele utiliza o validation group Default, 
	 * que é defindo pela Interface Default.class
	 * A anotação ConvertGroup permite converter do validation group padrão para um validation group específico, 
	 * quando houver o cascateamento da validação.
	 * */
	@ConvertGroup(from = Default.class, to = ValidationGroups.ClienteId.class)
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
	
	/* O padrão ISO-8601 é o padrão internacional para data/hora. 
	 * Ela precisa enviar o offset, que refere o fuso horário em relação ao meridiano de greenwich.
	 * Assim será possível saber qual o fuso horário, como o papa ou zulo.
	 * A classe LocalDateTime não retorna o offset.
	 * A classe OffsetDateTime retorna o offset.
	 * */
	@JsonProperty(access = Access.READ_ONLY)
	private OffsetDateTime dataAbertura;
	
	@JsonProperty(access = Access.READ_ONLY)
	private OffsetDateTime dataFinalizacao;
	
}
