package com.engsoft.sistemaDoacao.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table
@Data
@NoArgsConstructor
public class Pessoa {

	@Id
	@GeneratedValue
	private Long id;

	private String nome;

	private String telefone;

	private String cep;

	private Integer numero;

	private String cpf;

	private TipoPessoa tipo;

	@OneToOne
	@JoinColumn(name = "bairro_id")
	private Bairro bairro;

	@Column(name = "bairro_id", insertable = false, updatable = false)
	private Long idBairro;

}
