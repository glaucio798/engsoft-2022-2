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
import com.engsoft.sistemaDoacao.model.ListaDeEspera;

@Controller
@RestController
@RequestMapping("/bairro")
public class ControllerBairro extends ControllerBase<Bairro, Long> {

	@PersistenceContext
	EntityManager entityManager;

	@Override
	@Transactional
	@PostMapping
	public boolean cadastraEntidade(@RequestBody Bairro bairro) {
		ListaDeEspera listaDeEspera = new ListaDeEspera();
		this.entityManager.persist(listaDeEspera);

		bairro.setListaDeEspera(listaDeEspera);
		this.entityManager.persist(bairro);

		return true;
	}


	@Override
	@PutMapping
	public boolean editarEntidade(@RequestBody Bairro bairro) {
		this.entityManager.merge(bairro);
		return true;
	}

	@DeleteMapping
	public boolean excluirEntidade(@PathVariable Long id) {
		Bairro p = this.entityManager.find(Bairro.class, id);

		if(p != null) {
			this.entityManager.remove(p);
			return true;
		}

		return false;
	}

	@Override
	@GetMapping("/{id}")
	public Bairro recuperaEntidade(@PathVariable Long id) {
		return this.entityManager.find(Bairro.class, id);
	}

	@Override
	@GetMapping("/all")
	public List<Bairro> listaEntidades() {
		return this.entityManager.createQuery("select b from Bairro b", Bairro.class)
				.getResultList();
	}
}
