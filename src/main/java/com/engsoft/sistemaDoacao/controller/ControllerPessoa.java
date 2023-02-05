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
import com.engsoft.sistemaDoacao.model.Pessoa;

@Controller
@RestController
@RequestMapping("/pessoa")
public class ControllerPessoa extends ControllerBase<Pessoa, Long> {

	@PersistenceContext
	EntityManager entityManager;

	@Override
	@Transactional
	@PostMapping
	public boolean cadastraEntidade(@RequestBody Pessoa pessoa) {
		entityManager.persist(pessoa);
		return true;
	}


	@Override
	@PutMapping
	public boolean editarEntidade(@RequestBody Pessoa pessoa) {
		entityManager.merge(pessoa);
		return true;
	}

	@DeleteMapping
	public boolean excluirEntidade(Long id) {
		Pessoa p = this.entityManager.find(Pessoa.class, id);

		if(p != null) {
			this.entityManager.remove(p);
			return true;
		}

		return false;
	}

	@Override
	@GetMapping("/{id}")
	public Pessoa recuperaEntidade(@PathVariable Long id) {
		return this.entityManager.find(Pessoa.class, id);
	}

	@Override
	@GetMapping("/all")
	public List<Pessoa> listaEntidades() {
		return this.entityManager.createQuery("select t from Pessoa t", Pessoa.class)
				.getResultList();
	}

	@Transactional
	@PostMapping("/vinculabairro/{idPessoa}/{idBairro}")
	public boolean vinculaPessoaABairro(@PathVariable Long idPessoa, @PathVariable Long idBairro) {
		Bairro bairro = this.entityManager.getReference(Bairro.class, idBairro);

		Pessoa pessoa = recuperaEntidade(idPessoa);
		pessoa.setBairro(bairro);

		this.entityManager.merge(pessoa);

		return true;
	}
}
