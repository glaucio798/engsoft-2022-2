package com.engsoft.sistemaDoacao.controller;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.engsoft.sistemaDoacao.model.Doacao;
import com.engsoft.sistemaDoacao.model.ListaDeEspera;
import com.engsoft.sistemaDoacao.model.Pessoa;
import com.engsoft.sistemaDoacao.model.ReciboDoacao;

@Controller
@RestController
@RequestMapping("/doacao")
public class ControllerDoacao extends ControllerBase<Doacao, Long> {

	@PersistenceContext
	EntityManager entityManager;

	@Override
	@Transactional
	@PostMapping
	public boolean cadastraEntidade(@RequestBody Doacao doacao) {
		ListaDeEspera listaDeEspera = this.entityManager.getReference(ListaDeEspera.class, doacao.getIdListaDeEspera());
		doacao.setListaDeEspera(listaDeEspera);

		doacao.setNumeroCestasAtuais(doacao.getNumeroCestasDoadas());

		doacao.setDataDoacao(LocalDate.now());

		Pessoa doador = this.entityManager.getReference(Pessoa.class, doacao.getIdDoador());
		doacao.setDoador(doador);

		this.entityManager.persist(doacao);
		return true;
	}


	@Override
	@PutMapping
	public boolean editarEntidade(@RequestBody Doacao doacao) {
		this.entityManager.merge(doacao);
		return true;
	}

	@DeleteMapping
	public boolean excluirEntidade(Long id) {
		Doacao p = this.entityManager.find(Doacao.class, id);

		if(p != null) {
			this.entityManager.remove(p);
			return true;
		}

		return false;
	}

	@Override
	@GetMapping("/{id}")
	public Doacao recuperaEntidade(Long id) {
		return this.entityManager.find(Doacao.class, id);
	}

	@Override
	@GetMapping("/all")
	public List<Doacao> listaEntidades() {
		return this.entityManager.createQuery("select d from Doacao d", Doacao.class)
				.getResultList();
	}

	@Transactional
	@PostMapping("/registrarepasse/{idLista}/{idRecebedor}")
	public boolean registraRepasseDoacao(@PathVariable Long idLista, @PathVariable Long idRecebedor, @RequestBody Integer qntCestasDoadas) {
		Pessoa recebedor = this.entityManager.find(Pessoa.class, idRecebedor);

		Doacao doacao = getDoacaoDisponivel(recebedor.getBairro().getIdListaDeEspera());

		ReciboDoacao reciboDoacao = new ReciboDoacao();
		reciboDoacao.setDataRecebimento(LocalDate.now());
		reciboDoacao.setQntCestasDoadas(qntCestasDoadas);
		reciboDoacao.setRecebedor(recebedor);
		reciboDoacao.setDoacao(doacao);
		this.entityManager.persist(reciboDoacao);

		doacao.removerCestas(qntCestasDoadas);
		return true;
	}

	private Doacao getDoacaoDisponivel(Long idLista) {
		return
			this.entityManager.createQuery(
				"select d from Doacao d "
				+ "where d.listaDeEspera.id = " + idLista
				+ " and d.numeroCestasAtuais > 0"
				+ " and d.dataVencimentoLote > now() "
				+ "order by d.dataVencimentoLote", Doacao.class)
			.getSingleResult();
	}
}
