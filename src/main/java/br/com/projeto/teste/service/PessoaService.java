package br.com.projeto.teste.service;

import java.io.Serializable;
import java.util.HashMap;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import br.com.projeto.teste.entity.Pessoa;
import br.com.projeto.teste.ext.ExceptionIdNaoEncontrado;

@Named
@SessionScoped
public class PessoaService implements Serializable {

	private static final long serialVersionUID = 7951866566758915339L;

	HashMap<Integer, Pessoa> pessoas = new HashMap<Integer, Pessoa>();

	public void adicionarPessoa(Pessoa pessoa) {
		pessoas.put(pessoa.getId(), pessoa);
	}

	public void deletarPessoa(Integer id) {
		pessoas.remove(id);
	}

	public Pessoa buscarPessoa(Integer id) throws ExceptionIdNaoEncontrado{
		if (pessoas.get(id) != null) {
			return pessoas.get(id);
		}else {
			throw new ExceptionIdNaoEncontrado("ID não encontrado!");
		}	
	}

	public HashMap<Integer, Pessoa> buscarTodos() {
		return pessoas;
	}

	public void alterarPessoa(Pessoa pessoa) {
		pessoas.put(pessoa.getId(), pessoa);
	}
}
