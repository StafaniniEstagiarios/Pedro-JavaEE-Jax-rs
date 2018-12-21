package br.com.projeto.teste.service;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.projeto.teste.dao.PessoaDAO;
import br.com.projeto.teste.entity.Pessoa;

@Named
@SessionScoped
public class PessoaService implements Serializable {

	private static final long serialVersionUID = 7951866566758915339L;
	
	@Inject
	PessoaDAO pessoaDAO;
	
	public Pessoa adicionarPessoa(Pessoa pessoa) {
		return pessoaDAO.insert(pessoa);
	}

	public Pessoa deletarPessoa(int id) {
		Pessoa pessoa = pessoaDAO.find(id);
		return pessoaDAO.delete(pessoa);
	}

	public Pessoa buscarPessoa(Integer id) {
		return pessoaDAO.find(id);
	}

	public List<Pessoa> buscarTodos() {
		return pessoaDAO.findAll();
	}

	public Pessoa alterarPessoa(Pessoa pessoa) {
		return pessoaDAO.update(pessoa);
	}
}
