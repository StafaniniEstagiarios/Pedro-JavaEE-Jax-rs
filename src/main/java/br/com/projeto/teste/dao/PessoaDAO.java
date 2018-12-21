package br.com.projeto.teste.dao;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import br.com.projeto.teste.entity.Pessoa;

@Named
@RequestScoped
public class PessoaDAO extends GenericDAO<Pessoa> {

	private static final long serialVersionUID = 1201706129038788061L;

	public PessoaDAO() {
		super(Pessoa.class);
	}
}
