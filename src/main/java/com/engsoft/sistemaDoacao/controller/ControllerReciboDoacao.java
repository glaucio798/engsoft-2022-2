package com.engsoft.sistemaDoacao.controller;

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

import com.engsoft.sistemaDoacao.model.Bairro;
import com.engsoft.sistemaDoacao.model.ReciboDoacao;

@Controller
@RestController
@RequestMapping("/reciboDoacao")
public class ControllerReciboDoacao extends ControllerBase<ReciboDoacao, Long> {

	@PersistenceContext
	EntityManager entityManager;

	@Override
	@Transactional
	@PostMapping
	public boolean cadastraEntidade(@RequestBody ReciboDoacao reciboDoacao) {
		entityManager.persist(reciboDoacao);
		return true;
	}

	@Override
	@PutMapping
	public boolean editarEntidade(@RequestBody ReciboDoacao reciboDoacao) {
		entityManager.merge(reciboDoacao);
		return true;
	}

	@DeleteMapping
	public boolean excluirEntidade(Long id) {
		ReciboDoacao rd = this.entityManager.find(ReciboDoacao.class, id);

		if (rd != null) {
			this.entityManager.remove(rd);
			return true;
		}

		return false;
	}

	@Override
	@GetMapping("/{id}")
	public ReciboDoacao recuperaEntidade(@PathVariable Long id) {
		return this.entityManager.find(ReciboDoacao.class, id);
	}

	@Override
	@GetMapping("/all")
	public List<ReciboDoacao> listaEntidades() {
		return this.entityManager.createQuery("select rd from ReciboDoacao rd", ReciboDoacao.class)
				.getResultList();
	}
}
