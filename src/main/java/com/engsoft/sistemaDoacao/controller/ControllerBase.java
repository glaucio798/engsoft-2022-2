package com.engsoft.sistemaDoacao.controller;

import java.util.List;

import javax.transaction.Transactional;

public abstract class ControllerBase<T, V> {

	@Transactional
	public abstract boolean cadastraEntidade(T t);

	public abstract boolean editarEntidade(T t);

	public abstract boolean excluirEntidade(V id);

	public abstract T recuperaEntidade(V id);

	public abstract List<T> listaEntidades();

}
