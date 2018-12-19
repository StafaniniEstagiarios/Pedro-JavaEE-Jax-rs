package br.com.projeto.teste.service;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import br.com.projeto.teste.dao.PessoaDAO;
import br.com.projeto.teste.entity.Pessoa;

@Named
@SessionScoped
public class PessoaService implements Serializable {

	private static final long serialVersionUID = 7951866566758915339L;

	public Pessoa adicionarPessoa(Pessoa pessoa) {
		return PessoaDAO.getInstance().adicionarPessoa(pessoa);
	}

	public String deletarPessoa(Integer id) {
		return PessoaDAO.getInstance().deletarPessoa(id);
	}

	public Pessoa buscarPessoa(Integer id) {
		return PessoaDAO.getInstance().buscarPessoa(id);
	}

	public List<Pessoa> buscarTodos() {
		return PessoaDAO.getInstance().buscarTodos();
	}

	public Pessoa alterarPessoa(Pessoa pessoa) {
		return PessoaDAO.getInstance().alterarPessoa(pessoa);
	}
}
