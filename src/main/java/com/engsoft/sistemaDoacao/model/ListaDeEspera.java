package com.engsoft.sistemaDoacao.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table
@Data
public class ListaDeEspera {

	@Id
	@GeneratedValue
	private Long id;

	@OneToOne
	@JoinColumn(name = "agente_id")
	private Pessoa agente;

}
