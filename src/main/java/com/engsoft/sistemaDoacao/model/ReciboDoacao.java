package com.engsoft.sistemaDoacao.model;

import java.time.LocalDate;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table
@Data
public class ReciboDoacao {

	@Id
	@GeneratedValue
	private Long id;

	private int qntCestasDoadas;

	private LocalDate dataRecebimento;

	@OneToOne
	@JoinColumn(name = "recebedor_id")
	private Pessoa recebedor;

	@Column(name = "recebedor_id", insertable = false, updatable = false)
	private Long idRecebedor;

	@OneToOne
	@JoinColumn(name = "doacao_id")
	private Doacao doacao;

	@Column(name = "doacao_id", insertable = false, updatable = false)
	private Long idDoacao;

}
