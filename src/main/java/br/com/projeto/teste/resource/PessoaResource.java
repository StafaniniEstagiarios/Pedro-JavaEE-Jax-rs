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
import javax.ws.rs.core.Response;

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
	public Response buscarPorId(@PathParam("id") int id) throws ExceptionIdNaoEncontrado {
		String resultado = pessoaService.buscarPessoa(id).toString();
		return Response.status(200).entity(resultado).build();
	}

	@POST
	@Consumes("application/json")
	public Response criaPessoa(Pessoa pessoa) {
		String resultado = "Pessoa criada : " + pessoa.toString();
		pessoaService.adicionarPessoa(pessoa);
		return Response.status(201).entity(resultado).build();
	}

	@PUT
	@Consumes("application/json")
	public String alteraPessoa(Pessoa pessoa) throws ExceptionIdNaoEncontrado {
		Pessoa pessoaAlterada = pessoaService.buscarPessoa(pessoa.getId());
		pessoaAlterada.setCargo(pessoa.getCargo());
		pessoaAlterada.setIdade(pessoa.getIdade());
		pessoaAlterada.setNome(pessoa.getNome());
		pessoaService.alterarPessoa(pessoaAlterada);
		return pessoa.toString();
	}

	@DELETE
	@Path("/{id}")
	public String deletarPessoa(@PathParam("id") int id) {
		pessoaService.deletarPessoa(id);
		return "Pessoa " + id + " foi removida com sucesso";
	}
}
