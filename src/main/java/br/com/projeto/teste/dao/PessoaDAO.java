package br.com.projeto.teste.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.projeto.teste.entity.Pessoa;
import br.com.projeto.teste.entityManager.JpaEntityManager;


public class PessoaDAO  {
	private JpaEntityManager JPAEM = new JpaEntityManager();
	private EntityManager objEM = JPAEM.getEntityManager();
	private static final PessoaDAO instance = new PessoaDAO();

	public static PessoaDAO getInstance() {
		return instance;
	}

	@SuppressWarnings("unchecked")
	public List<Pessoa> buscarTodos() {
		Query query = objEM.createNamedQuery("Pessoa.findAll");
		objEM.close();
		return query.getResultList();
	}

	public Pessoa alterarPessoa(Pessoa pessoa) {
		objEM.getTransaction().begin();
		objEM.merge(pessoa);
		objEM.getTransaction().commit();
		Pessoa pessoaAlterada = this.buscarPessoa(pessoa.getId());
		objEM.close();
		return pessoaAlterada;
	}

	public Pessoa adicionarPessoa(Pessoa pessoa) {
		objEM.getTransaction().begin();
		objEM.persist(pessoa);
		objEM.getTransaction().commit();
		objEM.close();
		return buscarPessoa(pessoa.getId());
	}

	public String deletarPessoa(Integer id) {
		Pessoa pessoa = objEM.find(Pessoa.class, id);
		objEM.getTransaction().begin();
		objEM.remove(pessoa);
		objEM.getTransaction().commit();
		objEM.close();
		return "Pessoa excluída!";
	}

	public Pessoa buscarPessoa(Integer id) {
		Pessoa pessoa = objEM.find(Pessoa.class, id);
		return pessoa;
	}

}
