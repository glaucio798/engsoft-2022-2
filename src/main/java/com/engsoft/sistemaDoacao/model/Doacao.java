package com.engsoft.sistemaDoacao.model;

import java.time.LocalDate;

import lombok.Data;

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
public class Doacao {

	@Id
	@GeneratedValue
	private Long id;

	@ManyToOne
	@JoinColumn(name = "doador_id")
	private Pessoa doador;

	@Column(name = "doador_id", insertable = false, updatable = false)
	private Long idDoador;

	private Integer numeroCestasDoadas;

	private Integer numeroCestasAtuais;

	private LocalDate dataVencimentoLote;

	private LocalDate dataDoacao;

	@OneToOne
	@JoinColumn(name = "lista_de_espera_id")
	private ListaDeEspera listaDeEspera;

	@Column(name = "lista_de_espera_id", insertable = false, updatable = false)
	private Long idListaDeEspera;

	public void removerCestas(Integer qntCestasDoadas) {
		if(qntCestasDoadas > this.getNumeroCestasAtuais())
			throw new IllegalArgumentException("Não há cestas o suficiente para essa doação");

		this.setNumeroCestasAtuais(this.getNumeroCestasAtuais() - qntCestasDoadas);
	}
}
