package br.com.projeto.teste.resource;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import br.com.projeto.teste.entity.Pessoa;
import br.com.projeto.teste.ext.ExceptionIdNaoEncontrado;
import br.com.projeto.teste.service.PessoaService;

@Path("/pessoas")
public class PessoaResource {

	@Inject
	PessoaService pessoaService;

	@GET
	@Produces("application/json")
	public List<Pessoa> getPessoas() {
		return pessoaService.buscarTodos();
	}

	@GET
	@Path("/{id}")
	@Produces("application/json")
	public Pessoa buscarPorId(@PathParam("id") int id) throws ExceptionIdNaoEncontrado {
		return pessoaService.buscarPessoa(id);
	}

	@POST
	@Consumes("application/json")
	public Pessoa criaPessoa(Pessoa pessoa) {
		return pessoaService.adicionarPessoa(pessoa);
	}

	@PUT
	@Consumes("application/json")
	public Pessoa alteraPessoa(Pessoa pessoa) throws ExceptionIdNaoEncontrado {
		Pessoa pessoaAlterada = pessoaService.buscarPessoa(pessoa.getId());
		pessoaAlterada.setCargo(pessoa.getCargo());
		pessoaAlterada.setIdade(pessoa.getIdade());
		pessoaAlterada.setNome(pessoa.getNome());
		pessoaService.alterarPessoa(pessoaAlterada);
		return pessoa;
	}

	@DELETE
	@Path("/{id}")
	public Pessoa deletarPessoa(@PathParam("id") int id) {
		return pessoaService.deletarPessoa(id);
	}
}
