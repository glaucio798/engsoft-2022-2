package com.engsoft.sistemaDoacao.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Table
@Entity
@Data
public class Bairro {

	@Id
	@GeneratedValue
	private Long id;

	private String nomeBairro;

	@ManyToOne
	@JoinColumn(name = "lista_de_espera_id")
	private ListaDeEspera listaDeEspera;

	@Column(name = "lista_de_espera_id", insertable = false, updatable = false)
	private Long idListaDeEspera;
}
